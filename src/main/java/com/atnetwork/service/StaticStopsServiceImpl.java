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

import com.atnetwork.entity.StaticStopsBean;
import com.atnetwork.mapper.StaticStopsMapper;

/**
 * @author weiwei
 *
 */
@Service
public class StaticStopsServiceImpl implements StaticStopsService {
	
	@Autowired
	StaticStopsMapper stopsMapper;
	
	private Logger logger = LoggerFactory.getLogger(StaticStopsServiceImpl.class);

	@Override
	public int addStaticStops(StaticStopsBean ppb) {
		// TODO Auto-generated method stub
		if (ppb == null) {
			logger.error("Input static stops bean is null");
			return 0;
		}
		return stopsMapper.addStaticStops(ppb);
	}

	@Override
	public int updateStaticStops(StaticStopsBean ppb) {
		// TODO Auto-generated method stub
		if (ppb == null) {
			logger.error("Input static stops bean is null");
			return 0;
		}
		return stopsMapper.updateStaticStops(ppb);
	}

	@Override
	public int deleteStaticStops(String stop_id) {
		// TODO Auto-generated method stub
		if (StringUtils.isBlank(stop_id)) {
			logger.error("Input static stops bean is null");
			return 0;
		}
		return stopsMapper.deleteStaticStops(stop_id);
	}

	@Override
	public StaticStopsBean getStaticStops(String stop_id) {
		// TODO Auto-generated method stub
		if (StringUtils.isBlank(stop_id)) {
			logger.error("Input stop id is null");
			return null;
		}
		return stopsMapper.getStaticStops(stop_id);
	}

	@Override
	public List<StaticStopsBean> getStaticBeansList() {
		// TODO Auto-generated method stub
		return stopsMapper.getStaticStopsList();
	}

	@Override
	public int deleteStaticStopsAll() {
		// TODO Auto-generated method stub
		return stopsMapper.deleteAll();
	}

}
