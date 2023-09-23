/**
 * 
 */
package com.atnetwork.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atnetwork.entity.StaticTripsBean;

/**
 * @author weiwei
 *
 */
public interface StaticTripsService {
	int addStaticTrips(StaticTripsBean ppb);
	int batchAddStaticTrips(List<StaticTripsBean> ssblist);
	int updateStaticTrips(StaticTripsBean ppb);
	int deleteStaticTrips(@Param("trip_id")String trip_id);
	int deleteStaticTripsAll();
	StaticTripsBean getStaticTrips(@Param("trip_id")String trip_id);
	List<StaticTripsBean> getStaticBeansList();
	List<StaticTripsBean> getStaticBeansListByRoutes(@Param("route_id")String route_id);
}
