/**
 * 
 */
package com.atnetwork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atnetwork.entity.StaticCalendarDatesBean;
import com.atnetwork.mapper.StaticCalendarDatesMapper;

/**
 * @author weiwei
 *
 */
@Service
public class StaticCalendarDatesServiceImpl implements StaticCalendarDatesService {
	
	private Logger logger = LoggerFactory.getLogger(StaticCalendarDatesServiceImpl.class);
	
	@Autowired
	StaticCalendarDatesMapper scdm;
	
	@Override
	public int addStaticCalendarDates(StaticCalendarDatesBean ppb) {
		// TODO Auto-generated method stub
		if (ppb == null) {
			logger.error("Input static calendar_dates bean is null");
			return 0;
		}
		return scdm.addStaticCalendarDates(ppb);
	}

	@Override
	public int deleteStaticCalendarDates(String service_id) {
		// TODO Auto-generated method stub
		if (StringUtils.isBlank(service_id)) {
			logger.error("Input service_id is null");
			return 0;
		}
		return scdm.deleteStaticCalendarDates(service_id);
	}

	@Override
	public int deleteStaticCalendarDatesAll() {
		// TODO Auto-generated method stub
		return scdm.deleteAll();
	}

	@Override
	public StaticCalendarDatesBean getStaticCalendarDates(String service_id) {
		// TODO Auto-generated method stub
		if (StringUtils.isBlank(service_id)) {
			logger.error("Input service_id is null");
			return null;
		}
		return scdm.getStaticCalendarDates(service_id);
	}

	@Override
	public List<StaticCalendarDatesBean> getStaticDatesBeansList() {
		// TODO Auto-generated method stub
		return scdm.getStaticCalendarDatesList();
	}

	@Override
	public int batchAddStaticCalendarDates(List<StaticCalendarDatesBean> ssblist) {
		// TODO Auto-generated method stub
		if ((ssblist == null) || (ssblist.size() == 0)) {
			logger.error("Input static calendar_date list is null");
			return 0;
		}
		return scdm.batchAddStaticCalendarDates(ssblist);
	}

}
