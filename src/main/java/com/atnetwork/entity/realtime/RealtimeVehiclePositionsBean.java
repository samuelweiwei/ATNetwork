/**
 * 
 */
package com.atnetwork.entity.realtime;

import java.io.Serializable;

/**
 * @author weiwei
 *
 */
public class RealtimeVehiclePositionsBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String status;
	RealtimeVehiclePositionsResponse response;
	RealtimeServiceAlertError error;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public RealtimeVehiclePositionsResponse getResponse() {
		return response;
	}
	public void setResponse(RealtimeVehiclePositionsResponse response) {
		this.response = response;
	}
	public RealtimeServiceAlertError getError() {
		return error;
	}
	public void setError(RealtimeServiceAlertError error) {
		this.error = error;
	}

}
