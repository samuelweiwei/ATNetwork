/**
 * 
 */
package com.atnetwork.entity.realtime;

/**
 * @author weiwei
 *
 */
public class RealtimeTripUpdateEntity {
	private String id;
	private boolean is_deleted=false;
	private RealtimeTripUpdateBody trip_update;
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
	public RealtimeTripUpdateBody getTrip_update() {
		return trip_update;
	}
	public void setTrip_update(RealtimeTripUpdateBody trip_update) {
		this.trip_update = trip_update;
	}

}
