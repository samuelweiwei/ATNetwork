/**
 * 
 */
package com.atnetwork.entity.realtime;

/**
 * @author weiwei
 *
 */
public class RealtimeServiceAlertEntity {
	private String id;
	private RealtimeServiceAlertBody alert;
	private String timestamp;
	private boolean is_deleted = false;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public RealtimeServiceAlertBody getAlert() {
		return alert;
	}
	public void setAlert(RealtimeServiceAlertBody alert) {
		this.alert = alert;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public boolean isIs_deleted() {
		return is_deleted;
	}
	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}
}
