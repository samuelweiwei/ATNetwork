/**
 * 
 */
package com.atnetwork.entity.realtime;

/**
 * @author weiwei
 *
 */
public class RealtimeTripUpdateTrip {
	private String trip_id;
	private String start_time;
	private String start_date;
	private byte schedule_relationship;
	private String route_id;
	private byte direction_id;
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public byte getSchedule_relationship() {
		return schedule_relationship;
	}
	public void setSchedule_relationship(byte schedule_relationship) {
		this.schedule_relationship = schedule_relationship;
	}
	public String getRoute_id() {
		return route_id;
	}
	public void setRoute_id(String route_id) {
		this.route_id = route_id;
	}
	public byte getDirection_id() {
		return direction_id;
	}
	public void setDirection_id(byte direction_id) {
		this.direction_id = direction_id;
	}
	public String getTrip_id() {
		return trip_id;
	}
	public void setTrip_id(String trip_id) {
		this.trip_id = trip_id;
	}
}
