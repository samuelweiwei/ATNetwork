/**
 * 
 */
package com.atnetwork.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atnetwork.entity.StaticCalendarBean;
import com.atnetwork.entity.StaticCalendarDatesBean;

/**
 * @author weiwei
 *
 */
public interface StaticCalendarDatesService {
	int addStaticCalendarDates(StaticCalendarDatesBean ppb);
	int batchAddStaticCalendarDates(List<StaticCalendarDatesBean> ssblist);
	int deleteStaticCalendarDates(@Param("service_id")String service_id);
	int deleteStaticCalendarDatesAll();
	StaticCalendarDatesBean getStaticCalendarDates(@Param("service_id")String service_id);
	List<StaticCalendarDatesBean> getStaticDatesBeansList();
}
