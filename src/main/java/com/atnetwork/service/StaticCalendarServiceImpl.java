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

import com.atnetwork.entity.StaticCalendarBean;
import com.atnetwork.mapper.StaticCalendarMapper;

/**
 * @author weiwei
 *
 */
@Service
public class StaticCalendarServiceImpl implements StaticCalendarService {

	Logger logger = LoggerFactory.getLogger(StaticCalendarServiceImpl.class);
	
	@Autowired
	StaticCalendarMapper scm;
	
	@Override
	public int addStaticCalendar(StaticCalendarBean ppb) {
		// TODO Auto-generated method stub
		if (ppb == null) {
			logger.error("Input static calendar bean is null");
			return 0;
		}
		return scm.addStaticCalendar(ppb);
	}

	@Override
	public int deleteStaticCalendar(String service_id) {
		// TODO Auto-generated method stub
		if (StringUtils.isBlank(service_id)) {
			logger.error("Input service id is null");
			return 0;
		}
		return scm.deleteStaticCalendar(service_id);
	}

	@Override
	public int deleteStaticCalendarAll() {
		// TODO Auto-generated method stub
		return scm.deleteAll();
	}

	@Override
	public StaticCalendarBean getStaticCalendar(String service_id) {
		// TODO Auto-generated method stub
		if (StringUtils.isBlank(service_id)) {
			logger.error("Input service id is null");
			return null;
		}
		return scm.getStaticCalendar(service_id);
	}

	@Override
	public List<StaticCalendarBean> getStaticBeansList() {
		// TODO Auto-generated method stub
		return scm.getStaticCalendarList();
	}

	@Override
	public int batchAddStaticCalendar(List<StaticCalendarBean> ssblist) {
		// TODO Auto-generated method stub
		if ((ssblist == null) || (ssblist.size() == 0)) {
			logger.error("Input static calendar list is null");
			return 0;
		}
		return scm.batchAddStaticCalendar(ssblist);
	}

}
