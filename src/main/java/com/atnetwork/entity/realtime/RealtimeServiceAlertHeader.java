/**
 * 
 */
package com.atnetwork.entity.realtime;

/**
 * @author weiwei
 *
 */
public class RealtimeServiceAlertHeader {
	private double timestamp;
	private String gtfs_realtime_version;
	private int incrementality;
	public double getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(double timestamp) {
		this.timestamp = timestamp;
	}
	public String getGtfs_realtime_version() {
		return gtfs_realtime_version;
	}
	public void setGtfs_realtime_version(String gtfs_realtime_version) {
		this.gtfs_realtime_version = gtfs_realtime_version;
	}
	public int getIncrementality() {
		return incrementality;
	}
	public void setIncrementality(int incrementality) {
		this.incrementality = incrementality;
	}

}
