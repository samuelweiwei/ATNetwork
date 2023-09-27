/**
 * 
 */
package com.atnetwork.entity.realtime;

import java.io.Serializable;

/**
 * @author weiwei
 *
 */
public class RealtimeTripUpdateBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String status;
	RealtimeTripUpdateResponse response;
	RealtimeServiceAlertError error;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public RealtimeServiceAlertError getError() {
		return error;
	}
	public void setError(RealtimeServiceAlertError error) {
		this.error = error;
	}
	public RealtimeTripUpdateResponse getResponse() {
		return response;
	}
	public void setResponse(RealtimeTripUpdateResponse response) {
		this.response = response;
	}
}
