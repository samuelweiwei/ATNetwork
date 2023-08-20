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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ResourceUtils;

import io.micrometer.common.util.StringUtils;

/**
 * @author weiwei
 *
 */
public class StaticGISDatasetReader {
	private String url;
	private String localfilepath;
	
	public final static String default_local_path = "./";
	public final static String default_url = "https://opendata.arcgis.com/api/v3/datasets/d5a4db7acb5a45a9a4f1bd08a3f0f0a6_2/downloads/data?format=geojson&spatialRefId=4326&where=1%3D1";
	
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
	
	public String buildFile() {
		try {
			URL url = this.getClass().getClassLoader().getResource(".");
			System.out.println(url.toURI().getPath());
			long time = System.currentTimeMillis();
			File myf = new File(url.toURI().getPath(), "record-"+time+".txt");
			if (myf.createNewFile()) {
		        System.out.println("File created: " + myf.getName());
		      } else {
		    	  
		        System.out.println("File already exists.");
		      }
			//Open read in stream
			BufferedInputStream bis = new BufferedInputStream(new URL(this.url).openStream());
			
			int available = bis.available();
			byte[] dataBuffer = new byte[available];
			bis.read(dataBuffer);			
			String st = new String(dataBuffer, StandardCharsets.UTF_8);
			System.out.println(st);
			bis.close();
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(myf));
			bw.write(st);
			bw.flush();
			bw.close();
			
		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
		return null;
	}
	
	public String readData(String url){
		if (!StringUtils.isBlank(url)) {
			this.url = url;
		}
		
		return null;
	}
	
	
	public static void main(String[] args) {
		StaticGISDatasetReader t = new StaticGISDatasetReader();
		t.buildFile();
	}
}
