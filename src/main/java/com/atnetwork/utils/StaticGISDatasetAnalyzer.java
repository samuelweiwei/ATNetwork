/**
 * 
 */
package com.atnetwork.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Map;

import org.apache.commons.collections4.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson2.JSON;
import com.atnetwork.dataset.DataAnalyzer;
import com.atnetwork.dataset.StopsAnalyzer;
import com.atnetwork.dataset.TripsAnalyzer;
import com.atnetwork.entity.StaticStopsBean;
import com.atnetwork.entity.StaticTripsBean;
import com.atnetwork.mapper.StaticStopsMapper;
import com.github.benmanes.caffeine.cache.Cache;

import io.micrometer.common.util.StringUtils;

/**
 * @author weiwei
 *
 */
@Component
public class StaticGISDatasetAnalyzer {

	private String filename;
	private String filetype;
	public final static String default_json_filename = "gtfs";
	public final static String default_json_filepath = ".";
	public final static String default_filetype = "txt";
	public final static String[] default_gtfs_static_filename = {"agency","calendar","calendar_dates", "fare_attributes",
																"fare_rules", "feed_info", "frequencies", "routes", "shapes",
																"stop_times", "stops", "transfers", "trips"};

	@Autowired
	private StaticStopsMapper stopsMapper;
	
	private static Logger logger = LoggerFactory.getLogger(StaticGISDatasetAnalyzer.class);
	
	public StaticGISDatasetAnalyzer() {
		this.filename = default_json_filename;
		this.filetype = default_filetype;
	}

	public StaticGISDatasetAnalyzer(String filename, String filetype) {
		if (!StringUtils.isBlank(filename)) {
			this.filename = filename;
		} else {
			this.filename = default_json_filename;
		}

		if (!StringUtils.isBlank(filetype)) {
			this.filetype = filetype;
		} else {
			this.filetype = default_filetype;
		}
	}

	/**
	 * 
	 * @param filepath
	 * @return the text data string from file
	 */
	public String readFileContent(String path, String name) {
		StringBuffer filedata = new StringBuffer();
		String filepath, filename;
		if (!StringUtils.isBlank(path)) {
			filepath = path;
		}else {
			filepath = default_json_filepath;
		}
		if (!StringUtils.isBlank(name)) {
			filename = name;
		}else {
			filename = this.default_json_filename;
		}
		try {
			String fullfilepath = filepath + File.separator+filename+"."+default_filetype;
//			ClassPathResource resource = new ClassPathResource(filepath);
//			File myf = resource.getFile();
//			System.out.println(myf);
			File myf = new File(fullfilepath);
			System.out.println(myf.getAbsolutePath());
			Scanner myReader = new Scanner(myf);
			if (myReader.hasNext()) {
				//read the first line
				String titles = myReader.nextLine();
				
				while (myReader.hasNextLine()) {
					String data = myReader.nextLine();
					System.out.println(data);
					//If add special marks here for further split to arrays
					filedata.append(data+":");
				}
			}
			
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An file found error occurred.");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("An file IO error occurred.");
			e.printStackTrace();
		}
		return filedata.toString();
	}

	/**
	 * 
	 * @param path
	 * @param name
	 * @param datatype
	 * @return
	 */
	public String readFileContentToDataList(String path, String name, String datatype) {
		StringBuffer filedata = new StringBuffer();
		String filepath, filename;
		List<String> retdata = null;
		if (!StringUtils.isBlank(path)) {
			filepath = path;
		}else {
			filepath = default_json_filepath;
		}
		if (!StringUtils.isBlank(name)) {
			filename = name;
		}else {
			filename = this.default_json_filename;
		}
		try {
			String fullfilepath = filepath + File.separator+filename+"."+default_filetype;
//			ClassPathResource resource = new ClassPathResource(filepath);
//			File myf = resource.getFile();
//			System.out.println(myf);
			File myf = new File(fullfilepath);
			System.out.println(myf.getAbsolutePath());
			Scanner myReader = new Scanner(myf);
			if (myReader.hasNext()) {
				//read the first line
				String titles = myReader.nextLine();
				retdata = new ArrayList<>(); 
				String jsonstr;
				while (myReader.hasNextLine()) {
					String data = myReader.nextLine();
//					System.out.println(data);
					//If add special marks here for further split to arrays
//					jsonstr = parseDataToDB(data, datatype);
//					if (!StringUtils.isBlank(jsonstr)) {
//						retdata.add(jsonstr);
//					}
					filedata.append(data+":");
				}
				jsonstr = parseDataToDB(filedata.substring(0, filedata.length()-1), datatype);
			}
			
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An file found error occurred.");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("An file IO error occurred.");
			e.printStackTrace();
		}
		String finalstr = JSON.toJSONString(retdata);
		return finalstr;
	}
	
	public String parseDataToDB(String data, String datatype) {
		if (StringUtils.isBlank(data) || StringUtils.isBlank(datatype)) {
			logger.error("Input data or datatype is null");
			return null;
		}
		System.out.println(data);
		String ret = null;
		String[] arr = data.split(":");
		switch(datatype.trim().toLowerCase()) {
			case "stops":
				DataAnalyzer<StaticStopsBean> sb = new StopsAnalyzer();
				List<StaticStopsBean> ssb = new ArrayList<>();
				for(String stop: arr) {
					StaticStopsBean result = sb.analyzedata(stop);
					if (result != null) {
						ssb.add(result);
					}
				}
				stopsMapper.deleteAll();
				//Avoid to big list size
				List<List<StaticStopsBean>> subs = this.partitionList(ssb);
				for(List<StaticStopsBean> sub: subs) {
					stopsMapper.batchAddStaticStops(sub);
				}
				ret = JSON.toJSONString(ssb);
				break;
			case "trips":
				DataAnalyzer<StaticTripsBean> st = new TripsAnalyzer();
				StaticTripsBean stb = st.analyzedata(data);
				ret = JSON.toJSONString(stb);
				break;				
			default:
				break;
		}
		return ret;
	}
	
	/**
	 * Must be version above java 8
	 * @param origin
	 * @return
	 */
	private <T> List<List<T>> partitionList(List<T> origin){
		if ((origin == null) || (origin.size() == 0)) {
			logger.error("Empty list to partition");
			return null;
		}
		int batchcount = 0;
		if (origin.size() > 500) {
			batchcount = origin.size() / 500;
		}
		List<List<T>> subs = ListUtils.partition(origin, batchcount);
		return subs;
	}
	
	public static void main(String[] args) {
		StaticGISDatasetAnalyzer read = new StaticGISDatasetAnalyzer();
		String data = read.readFileContent(".\\gtfs-2023-08-30-23-04-35", "stops");
		System.out.println(data);
	}
}
