/**
 * 
 */
package com.atnetwork.entity.realtime;

import java.io.Serializable;

/**
 * @author weiwei
 *
 */
public class RealtimeServiceAlertBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String status;
	RealtimeServiceAlertResponse response;
	RealtimeServiceAlertError error;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public RealtimeServiceAlertResponse getResponse() {
		return response;
	}
	public void setResponse(RealtimeServiceAlertResponse response) {
		this.response = response;
	}
	public RealtimeServiceAlertError getError() {
		return error;
	}
	public void setError(RealtimeServiceAlertError error) {
		this.error = error;
	}
}
