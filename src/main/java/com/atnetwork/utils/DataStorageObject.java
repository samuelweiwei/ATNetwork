/**
 * 
 */
package com.atnetwork.utils;

import java.util.ArrayList;

/**
 * @author weiwei
 *
 */
public class DataStorageObject {
	//Storage data format
	private ArrayList<String> data;
	
	public static DataStorageObject getInstance() {
		return new DataStorageObject();
	}

	public ArrayList<String> getData() {
		return data;
	}

	public void setData(ArrayList<String> data) {
		this.data = data;
	}
}
