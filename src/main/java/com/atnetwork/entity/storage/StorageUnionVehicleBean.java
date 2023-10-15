/**
 * 
 */
package com.atnetwork.entity.storage;

import com.atnetwork.entity.CommonDataType;

/**
 * @author weiwei
 *
 */
public class StorageUnionVehicleBean {
	private String route_id;
	private String trip_id;
	private String start_time;
	private String start_date;
	private byte schedule_relationship;
	private double latitude;
	private double longitude;
	private double speed;
	private String id; //for vehidle;
	private String label;
	private String license_plate;
	private byte occupancy_status = CommonDataType.occupancy_status_empty; //default empty
	public String getRoute_id() {
		return route_id;
	}
	public void setRoute_id(String route_id) {
		this.route_id = route_id;
	}
	public String getTrip_id() {
		return trip_id;
	}
	public void setTrip_id(String trip_id) {
		this.trip_id = trip_id;
	}
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
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getLicense_plate() {
		return license_plate;
	}
	public void setLicense_plate(String license_plate) {
		this.license_plate = license_plate;
	}
	public byte getOccupancy_status() {
		return occupancy_status;
	}
	public void setOccupancy_status(byte occupancy_status) {
		this.occupancy_status = occupancy_status;
	}	
	
}
