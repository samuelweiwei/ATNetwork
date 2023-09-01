/**
 * 
 */
package com.atnetwork.controller;

import java.io.Serializable;

/**
 * @author weiwei
 *
 */
public class ResultEntity<T> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String result; //"succeeded" means ok, "failed" mean problem
	private String errorcode;
	private T data;
	private String remarks;
	
	public static String result_succeeded = "succeeded";
	public static String result_failed = "failed";
	public static String common_errorcode = "common exception";
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

}
