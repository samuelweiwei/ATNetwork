/**
 * 
 */
package com.atnetwork.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atnetwork.entity.StaticTripsBean;
import com.atnetwork.mapper.StaticTripsMapper;

/**
 * @author weiwei
 *
 */
@Service
public class StaticTripsServiceImpl implements StaticTripsService {
	
	private Logger logger = LoggerFactory.getLogger(StaticTripsServiceImpl.class);
	
	@Autowired
	StaticTripsMapper stm;

	@Override
	public int addStaticTrips(StaticTripsBean ppb) {
		// TODO Auto-generated method stub
		if (ppb == null) {
			logger.error("Input static trips bean is null");
			return 0;
		}
		return stm.addStaticTrips(ppb);
	}

	@Override
	public int updateStaticTrips(StaticTripsBean ppb) {
		// TODO Auto-generated method stub
		if (ppb == null) {
			logger.error("Input static trips bean is null");
			return 0;
		}
		return stm.updateStaticTrips(ppb);
	}

	@Override
	public int deleteStaticTrips(String trip_id) {
		// TODO Auto-generated method stub
		if (StringUtils.isBlank(trip_id)) {
			logger.error("Input trip id is null");
			return 0;
		}
		return stm.deleteStaticTrips(trip_id);
	}

	@Override
	public StaticTripsBean getStaticTrips(String trip_id) {
		// TODO Auto-generated method stub
		if (StringUtils.isBlank(trip_id)) {
			logger.error("Input trip id is null");
			return null;
		}
		return stm.getStaticTrips(trip_id);
	}

	@Override
	public List<StaticTripsBean> getStaticBeansList() {
		// TODO Auto-generated method stub
		return stm.getStaticTripsList();
	}

	@Override
	public List<StaticTripsBean> getStaticBeansListByRoutes(String route_id) {
		// TODO Auto-generated method stub
		if (StringUtils.isBlank(route_id)) {
			logger.error("Input route id is null for trip search");
			return null;
		}
		return stm.getStaticTripsListByRoute(route_id);
	}

	@Override
	public int deleteStaticTripsAll() {
		// TODO Auto-generated method stub
		return stm.deleteAll();
	}

	@Override
	public int batchAddStaticTrips(List<StaticTripsBean> ssblist) {
		// TODO Auto-generated method stub
		if ((ssblist == null) || (ssblist.size() == 0)) {
			logger.error("Input static trips list is null");
			return 0;
		}
		return stm.batchAddStaticTrips(ssblist);
	}

}
