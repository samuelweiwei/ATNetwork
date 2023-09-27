/**
 * 
 */
package com.atnetwork.entity.realtime;

/**
 * @author weiwei
 *
 */
public class RealtimeServiceAlertResponse {
	RealtimeServiceAlertHeader header;
	RealtimeServiceAlertEntity[] entity;
	public RealtimeServiceAlertHeader getHeader() {
		return header;
	}
	public void setHeader(RealtimeServiceAlertHeader header) {
		this.header = header;
	}
	public RealtimeServiceAlertEntity[] getEntity() {
		return entity;
	}
	public void setEntity(RealtimeServiceAlertEntity[] entity) {
		this.entity = entity;
	}

}
