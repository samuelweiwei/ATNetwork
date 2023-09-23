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

import com.atnetwork.entity.StaticStopTimesBean;
import com.atnetwork.mapper.StaticStopTimesMapper;

/**
 * @author weiwei
 *
 */
@Service
public class StaticStopTimesServiceImpl implements StaticStopTimesService {
	
	private Logger logger = LoggerFactory.getLogger(StaticStopTimesServiceImpl.class);
	
	@Autowired
	StaticStopTimesMapper sstm;

	@Override
	public int addStaticStopTimes(StaticStopTimesBean ppb) {
		// TODO Auto-generated method stub
		if (ppb == null) {
			logger.error("Input sttic stop times bean is null");
			return 0;
		}
		return sstm.addStaticStopTimes(ppb);
	}

	@Override
	public int updateStaticStopTimes(StaticStopTimesBean ppb) {
		// TODO Auto-generated method stub
		if (ppb == null) {
			logger.error("Input sttic stop times bean is null");
			return 0;
		}
		return sstm.updateStaticStopTimes(ppb);
	}

	@Override
	public int deleteStaticStopTimes(String stop_id) {
		// TODO Auto-generated method stub
		if (StringUtils.isBlank(stop_id)) {
			logger.error("Input stop id is null");
			return 0;
		}
		return sstm.deleteStaticStopTimes(stop_id);
	}

	@Override
	public StaticStopTimesBean getStaticStopTimes(String stop_id) {
		// TODO Auto-generated method stub
		if (StringUtils.isBlank(stop_id)) {
			logger.error("Input stop id is null");
			return null;
		}
		return sstm.getStaticStopTimes(stop_id);
	}

	@Override
	public List<StaticStopTimesBean> getStaticBeansList() {
		// TODO Auto-generated method stub
		return sstm.getStaticStopTimesList();
	}

	@Override
	public int deleteStaticsStopTimesAll() {
		// TODO Auto-generated method stub
		return sstm.deleteAll();
	}

	@Override
	public int batchAddStaticStopTimes(List<StaticStopTimesBean> ssblist) {
		// TODO Auto-generated method stub
		if ((ssblist == null) || (ssblist.size() == 0)) {
			logger.error("Input static stop times list is null");
			return 0;
		}
		return sstm.batchAddStaticStopTimes(ssblist);
	}

}
