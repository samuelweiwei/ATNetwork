/**
 * 
 */
package com.atnetwork.entity.realtime;

/**
 * @author weiwei
 *
 */
public class RealtimeTripUpdateBody {
	private RealtimeTripUpdateTrip trip;
	private RealtimeTripUpdateStopTimeUpdate stop_time_update;
	private RealtimeTripUpdateVehicle vehicle;
	private long timestamp;
	private int delay;
	public RealtimeTripUpdateTrip getTrip() {
		return trip;
	}
	public void setTrip(RealtimeTripUpdateTrip trip) {
		this.trip = trip;
	}
	public RealtimeTripUpdateStopTimeUpdate getStop_time_update() {
		return stop_time_update;
	}
	public void setStop_time_update(RealtimeTripUpdateStopTimeUpdate stop_time_update) {
		this.stop_time_update = stop_time_update;
	}
	public RealtimeTripUpdateVehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(RealtimeTripUpdateVehicle vehicle) {
		this.vehicle = vehicle;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public int getDelay() {
		return delay;
	}
	public void setDelay(int delay) {
		this.delay = delay;
	}
	
}
