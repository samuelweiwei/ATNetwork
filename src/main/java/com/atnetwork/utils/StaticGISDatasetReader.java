/**
 * 
 */
package com.atnetwork.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ResourceUtils;

import io.micrometer.common.util.StringUtils;

/**
 * @author weiwei
 * @see Springframework tools
 * @see Apache common io tools
 */
public class StaticGISDatasetReader {
	private String url;
	private String localfilepath;
	
	public final static String default_local_path = ".";
//	public final static String default_url = "https://opendata.arcgis.com/api/v3/datasets/d5a4db7acb5a45a9a4f1bd08a3f0f0a6_2/downloads/data?format=geojson&spatialRefId=4326&where=1%3D1";
	public final static String default_url = "https://gtfs.at.govt.nz/gtfs.zip";
	
	public StaticGISDatasetReader() {
		this.url = default_url;
		this.localfilepath = default_local_path;
	}
	
	public StaticGISDatasetReader(String url, String local_path) {
		if (!StringUtils.isBlank(url)) {
			this.url = url;
		}else {
			this.url = default_url;
		}
		if (!StringUtils.isBlank(local_path)) {
			this.localfilepath = local_path;
		}else {
			this.localfilepath = default_local_path;
		}
	}
	
	/**
	 * Download the file and write into local file
	 * @return
	 */
	public void readDataToLocalFile() {
		try {
//			URL url = this.getClass().getClassLoader().getResource(".");
			URL url = new URL(this.url);
			System.out.println(url.toString());
			long time = System.currentTimeMillis();
//			File myf = new File(url.toURI().getPath(), "gtfs-"+time+".zip");
			File myf = new File(localfilepath+File.separator, "gtfs-"+time+".zip");
			if (!myf.exists())
				myf.mkdirs();
			System.out.println(myf.getAbsolutePath());
			FileUtils.copyURLToFile(url, myf);
//			if (myf.createNewFile()) {
//		        System.out.println("File created: " + myf.getName());
//		      } else {
//		    	  
//		        System.out.println("File already exists.");
//		      }
			//Try apache common IO
			
			//Open read in stream
//			BufferedInputStream bis = new BufferedInputStream(new URL(this.url).openStream());
//			
//			int available = bis.available();
//			byte[] total = new byte[available];
//			byte[] dataBuffer = new byte[available];
//			StringBuffer sb = new StringBuffer();
//			int i = 0;
//			BufferedWriter bw = new BufferedWriter(new FileWriter(myf, true));
//			while((bis.read(dataBuffer) != -1) && (i <= 1000)){
//				bis.read(dataBuffer);			
//				String st = new String(dataBuffer, StandardCharsets.UTF_8);
//				sb.append(st);
//				dataBuffer = new byte[bis.available()];
//				i++;
//
//				System.out.println("i is:"+i);
//				if (i == 1000) {
//					bw.write(sb.toString());
////					bw.flush();
//					i = 0;
//					sb = new StringBuffer();
//				}
//			}
//			bw.flush();
//			bw.close();
//			bis.close();			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
		return;
	}
	
	/**
	 * Testing stub
	 * @param args
	 */
	public static void main(String[] args) {
		StaticGISDatasetReader t = new StaticGISDatasetReader();
		t.readDataToLocalFile();
	}
}
