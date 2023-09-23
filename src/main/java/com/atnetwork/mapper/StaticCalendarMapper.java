/**
 * 
 */
package com.atnetwork.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.atnetwork.entity.StaticCalendarBean;

/**
 * @author weiwei
 *
 */
@Mapper
@Repository
public interface StaticCalendarMapper {
	int addStaticCalendar(@Param("ppb")StaticCalendarBean ppb);
	int batchAddStaticCalendar(@Param("ssblist")List<StaticCalendarBean> ssblist);
	int deleteStaticCalendar(@Param("service_id")String service_id);
	int deleteAll();
	StaticCalendarBean getStaticCalendar(@Param("service_id")String service_id);
	List<StaticCalendarBean> getStaticCalendarList();
}
