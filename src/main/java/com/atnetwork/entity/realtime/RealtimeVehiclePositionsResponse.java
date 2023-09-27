/**
 * 
 */
package com.atnetwork.entity.realtime;

/**
 * @author weiwei
 *
 */
public class RealtimeVehiclePositionsResponse {
	RealtimeServiceAlertHeader header;
	RealtimeVehiclePositionsEntity[] entity;
	public RealtimeServiceAlertHeader getHeader() {
		return header;
	}
	public void setHeader(RealtimeServiceAlertHeader header) {
		this.header = header;
	}
	public RealtimeVehiclePositionsEntity[] getEntity() {
		return entity;
	}
	public void setEntity(RealtimeVehiclePositionsEntity[] entity) {
		this.entity = entity;
	}
}
