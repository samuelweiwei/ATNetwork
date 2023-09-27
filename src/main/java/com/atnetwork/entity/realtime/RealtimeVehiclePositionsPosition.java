/**
 * 
 */
package com.atnetwork.entity.realtime;

/**
 * @author weiwei
 *
 */
public class RealtimeVehiclePositionsPosition {
	private double latitude;
	private double longitude;
	private double speed;
	private String bearing;
	private long odometer;
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
	public String getBearing() {
		return bearing;
	}
	public void setBearing(String bearing) {
		this.bearing = bearing;
	}
	public long getOdometer() {
		return odometer;
	}
	public void setOdometer(long odometer) {
		this.odometer = odometer;
	}
}
