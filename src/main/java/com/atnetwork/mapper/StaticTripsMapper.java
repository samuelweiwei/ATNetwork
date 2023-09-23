/**
 * 
 */
package com.atnetwork.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.atnetwork.entity.StaticTripsBean;

/**
 * @author weiwei
 *
 */
@Mapper
@Repository
public interface StaticTripsMapper {
	int addStaticTrips(@Param("ppb")StaticTripsBean ppb);
	int batchAddStaticTrips(@Param("ssblist")List<StaticTripsBean> ssblist);
	int updateStaticTrips(@Param("ppb")StaticTripsBean ppb);
	int deleteStaticTrips(@Param("trip_id")String trip_id);
	int deleteAll();
	StaticTripsBean getStaticTrips(@Param("trip_id")String trip_id);
	List<StaticTripsBean> getStaticTripsListByRoute(@Param("route_id")String route_id);
	List<StaticTripsBean> getStaticTripsList();
}
 