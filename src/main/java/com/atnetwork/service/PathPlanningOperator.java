/**
 * 
 */
package com.atnetwork.service;

import java.util.List;

import com.atnetwork.entity.StaticStopsBean;

/**
 * @author weiwei
 * Acquire the latest updates on trips, vehicles and services to combine
 * into the network for path planning
 */
public interface PathPlanningOperator {
	
	void updateLatestServiceAlerts();
	void acquireLatestTripUpdates();
	void updateVehiclePositions();
	void acquireVehiclesFromTrip(String tripid);
    List<StaticStopsBean> pathPlanning(String destid, String sourceid);
}
