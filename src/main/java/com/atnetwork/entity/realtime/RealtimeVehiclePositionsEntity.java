/**
 * 
 */
package com.atnetwork.entity.realtime;

/**
 * @author weiwei
 *
 */
public class RealtimeVehiclePositionsEntity {
	private String id;
	private boolean is_deleted=false;
	private RealtimeVehiclePositionsBody vehicle;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isIs_deleted() {
		return is_deleted;
	}
	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}
	public RealtimeVehiclePositionsBody getVehicle() {
		return vehicle;
	}
	public void setVehicle(RealtimeVehiclePositionsBody vehicle) {
		this.vehicle = vehicle;
	}
}
