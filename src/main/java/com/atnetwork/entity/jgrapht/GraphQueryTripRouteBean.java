/**
 * 
 */
package com.atnetwork.entity.jgrapht;

/**
 * @author weiwei
 *
 */
public class GraphQueryTripRouteBean {
	private String route_id;
	private String trip_id;
	private int stop_sequence;
	private String stop_id;
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
	public int getStop_sequence() {
		return stop_sequence;
	}
	public void setStop_sequence(int stop_sequence) {
		this.stop_sequence = stop_sequence;
	}
	public String getStop_id() {
		return stop_id;
	}
	public void setStop_id(String stop_id) {
		this.stop_id = stop_id;
	}

}
