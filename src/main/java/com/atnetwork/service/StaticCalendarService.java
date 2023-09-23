/**
 * 
 */
package com.atnetwork.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atnetwork.entity.StaticCalendarBean;

/**
 * @author weiwei
 *
 */
public interface StaticCalendarService {
	int addStaticCalendar(StaticCalendarBean ppb);
	int batchAddStaticCalendar(List<StaticCalendarBean> ssblist);
	int deleteStaticCalendar(@Param("service_id")String service_id);
	int deleteStaticCalendarAll();
	StaticCalendarBean getStaticCalendar(@Param("service_id")String service_id);
	List<StaticCalendarBean> getStaticBeansList();
}
