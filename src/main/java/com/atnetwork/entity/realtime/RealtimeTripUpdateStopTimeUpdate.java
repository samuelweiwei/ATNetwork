/**
 * 
 */
package com.atnetwork.entity.realtime;

/**
 * @author weiwei
 *
 */
public class RealtimeTripUpdateStopTimeUpdate {
	private short stop_sequence;
	private RealtimeTripUpdateArrivalDeparture arrival;
	private RealtimeTripUpdateArrivalDeparture departure;
	private String stop_id;
	private byte schedule_relationship;
	public short getStop_sequence() {
		return stop_sequence;
	}
	public void setStop_sequence(short stop_sequence) {
		this.stop_sequence = stop_sequence;
	}
	public RealtimeTripUpdateArrivalDeparture getArrival() {
		return arrival;
	}
	public void setArrival(RealtimeTripUpdateArrivalDeparture arrival) {
		this.arrival = arrival;
	}
	public String getStop_id() {
		return stop_id;
	}
	public void setStop_id(String stop_id) {
		this.stop_id = stop_id;
	}
	public byte getSchedule_relationship() {
		return schedule_relationship;
	}
	public void setSchedule_relationship(byte schedule_relationship) {
		this.schedule_relationship = schedule_relationship;
	}
	public RealtimeTripUpdateArrivalDeparture getDeparture() {
		return departure;
	}
	public void setDeparture(RealtimeTripUpdateArrivalDeparture departure) {
		this.departure = departure;
	}
	
}
