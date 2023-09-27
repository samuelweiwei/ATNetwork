/**
 * 
 */
package com.atnetwork.entity.realtime;

/**
 * @author weiwei
 *
 */
public class RealtimeVehiclePositionsBody {
	private String id;
	private RealtimeVehiclePositionsPosition position;
	private RealtimeVehiclePositionsVehicle vehicle;
	private long timestamp;
	private RealtimeTripUpdateTrip trip;
	//Empty, Many seats available, Few seats available, Standing room only, Crushed standing room only, Full, Not accepting passengers
	private byte occupancy_status; //0,1,2,3,4,5,6 
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public RealtimeVehiclePositionsPosition getPosition() {
		return position;
	}
	public void setPosition(RealtimeVehiclePositionsPosition position) {
		this.position = position;
	}
	public RealtimeVehiclePositionsVehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(RealtimeVehiclePositionsVehicle vehicle) {
		this.vehicle = vehicle;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public RealtimeTripUpdateTrip getTrip() {
		return trip;
	}
	public void setTrip(RealtimeTripUpdateTrip trip) {
		this.trip = trip;
	}
	public byte getOccupancy_status() {
		return occupancy_status;
	}
	public void setOccupancy_status(byte occupancy_status) {
		this.occupancy_status = occupancy_status;
	}
	
	
}
