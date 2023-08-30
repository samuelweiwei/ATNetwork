/**
 * 
 */
package com.atnetwork.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.core.io.ClassPathResource;

import io.micrometer.common.util.StringUtils;

/**
 * @author weiwei
 *
 */
public class StaticGISDatasetAnalyzer {

	private String filename;
	private String filetype;
	public final static String default_json_filename = "BusRoute";
	public final static String default_filetype = "json";

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

	public String readFileContent() {
		StringBuffer filedata = new StringBuffer();
		try {
			String filepath = this.filename + "." + this.filetype;
			ClassPathResource resource = new ClassPathResource(filepath);
			File myf = resource.getFile();
			System.out.println(myf);
			Scanner myReader = new Scanner(myf);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
				filedata.append(data);
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

	public static void main(String[] args) {
		StaticGISDatasetAnalyzer read = new StaticGISDatasetAnalyzer();
		String data = read.readFileContent();
		System.out.println(data);
	}
}
