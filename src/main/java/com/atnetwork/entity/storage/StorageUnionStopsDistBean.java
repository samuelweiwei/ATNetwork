/**
 * 
 */
package com.atnetwork.entity.storage;

/**
 * @author weiwei
 *
 */
public class StorageUnionStopsDistBean{
	private String route_id;
	private String stop_id;
	private String trip_id;
	private String shape_id;
	private String stop_name;
	private String stop_desc;
	private String stop_lon;
	private String stop_lat;
	private String start_date; //yyyymmdd
	private String end_date; //yyyymmdd
	private String arrival_time;
	private String departure_time;
	private int stop_sequence;
	private float shape_dist_traveled;
	public String getStop_id() {
		return stop_id;
	}
	public void setStop_id(String stop_id) {
		this.stop_id = stop_id;
	}
	public String getTrip_id() {
		return trip_id;
	}
	public void setTrip_id(String trip_id) {
		this.trip_id = trip_id;
	}
	public String getShape_id() {
		return shape_id;
	}
	public void setShape_id(String shape_id) {
		this.shape_id = shape_id;
	}
	public String getStop_name() {
		return stop_name;
	}
	public void setStop_name(String stop_name) {
		this.stop_name = stop_name;
	}
	public String getStop_desc() {
		return stop_desc;
	}
	public void setStop_desc(String stop_desc) {
		this.stop_desc = stop_desc;
	}
	public String getStop_lon() {
		return stop_lon;
	}
	public void setStop_lon(String stop_lon) {
		this.stop_lon = stop_lon;
	}
	public String getStop_lat() {
		return stop_lat;
	}
	public void setStop_lat(String stop_lat) {
		this.stop_lat = stop_lat;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getArrival_time() {
		return arrival_time;
	}
	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}
	public String getDeparture_time() {
		return departure_time;
	}
	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}
	public int getStop_sequence() {
		return stop_sequence;
	}
	public void setStop_sequence(int stop_sequence) {
		this.stop_sequence = stop_sequence;
	}
	public float getShape_dist_traveled() {
		return shape_dist_traveled;
	}
	public void setShape_dist_traveled(float shape_dist_traveled) {
		this.shape_dist_traveled = shape_dist_traveled;
	}
	public String getRoute_id() {
		return route_id;
	}
	public void setRoute_id(String route_id) {
		this.route_id = route_id;
	}
}
