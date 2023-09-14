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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson2.JSON;
import com.atnetwork.dataset.DataAnalyzer;
import com.atnetwork.dataset.StopsAnalyzer;
import com.atnetwork.dataset.TripsAnalyzer;
import com.atnetwork.entity.StaticStopsBean;
import com.atnetwork.entity.StaticTripsBean;
import com.github.benmanes.caffeine.cache.Cache;

import io.micrometer.common.util.StringUtils;

/**
 * @author weiwei
 *
 */
public class StaticGISDatasetAnalyzer {

	private String filename;
	private String filetype;
	public final static String default_json_filename = "gtfs";
	public final static String default_json_filepath = ".";
	public final static String default_filetype = "txt";
	public final static String[] default_gtfs_static_filename = {"agency","calendar","calendar_dates", "fare_attributes",
																"fare_rules", "feed_info", "frequencies", "routes", "shapes",
																"stop_times", "stops", "transfers", "trips"};

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
					filedata.append(data+"+");
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
					System.out.println(data);
					//If add special marks here for further split to arrays
					jsonstr = parseDataToDB(data, datatype);
					if (!StringUtils.isBlank(jsonstr)) {
						retdata.add(jsonstr);
					}
//					filedata.append(data+"+");
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
		String finalstr = JSON.toJSONString(retdata);
		return finalstr;
	}
	
	public String parseDataToDB(String data, String datatype) {
		if (StringUtils.isBlank(data) || StringUtils.isBlank(datatype)) {
			logger.error("Input data or datatype is null");
			return null;
		}
		String ret = null;
		switch(datatype.trim().toLowerCase()) {
			case "stops":
				DataAnalyzer<StaticStopsBean> sb = new StopsAnalyzer();
				StaticStopsBean result = sb.analyzedata(data);
				ret = JSON.toJSONString(result);
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
	
	public static void main(String[] args) {
		StaticGISDatasetAnalyzer read = new StaticGISDatasetAnalyzer();
		String data = read.readFileContent(".\\gtfs-2023-08-30-23-04-35", "stops");
		System.out.println(data);
	}
}
