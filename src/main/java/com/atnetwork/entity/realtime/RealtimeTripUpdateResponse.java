/**
 * 
 */
package com.atnetwork.entity.realtime;

/**
 * @author weiwei
 *
 */
public class RealtimeTripUpdateResponse {
	RealtimeServiceAlertHeader header;
	RealtimeTripUpdateEntity[] entity;
	public RealtimeServiceAlertHeader getHeader() {
		return header;
	}
	public void setHeader(RealtimeServiceAlertHeader header) {
		this.header = header;
	}
	public RealtimeTripUpdateEntity[] getEntity() {
		return entity;
	}
	public void setEntity(RealtimeTripUpdateEntity[] entity) {
		this.entity = entity;
	}
}
