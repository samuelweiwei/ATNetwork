/**
 * 
 */
package com.atnetwork.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
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

	@Override
	public int addStaticStops(StaticStopsBean ppb) {
		// TODO Auto-generated method stub
		if (ppb == null)
			return 0;
		return stopsMapper.addStaticStops(ppb);
	}

	@Override
	public int updateStaticStops(StaticStopsBean ppb) {
		// TODO Auto-generated method stub
		if (ppb == null)
			return 0;
		return stopsMapper.updateStaticStops(ppb);
	}

	@Override
	public int deleteStaticStops(String stop_id) {
		// TODO Auto-generated method stub
		if (StringUtils.isBlank(stop_id))
			return 0;
		return stopsMapper.deleteStaticStops(stop_id);
	}

	@Override
	public StaticStopsBean getStaticStops(String stop_id) {
		// TODO Auto-generated method stub
		if (StringUtils.isBlank(stop_id))
			return null;
		return stopsMapper.getStaticStops(stop_id);
	}

	@Override
	public List<StaticStopsBean> getStaticBeansList() {
		// TODO Auto-generated method stub
		return stopsMapper.getStaticStopsList();
	}

}
