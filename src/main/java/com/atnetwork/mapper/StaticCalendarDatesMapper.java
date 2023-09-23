/**
 * 
 */
package com.atnetwork.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.atnetwork.entity.StaticCalendarDatesBean;

/**
 * @author weiwei
 *
 */
@Mapper
@Repository
public interface StaticCalendarDatesMapper {
	int addStaticCalendarDates(@Param("ppb")StaticCalendarDatesBean ppb);
	int batchAddStaticCalendarDates(@Param("ssblist")List<StaticCalendarDatesBean> ssblist);
	int deleteStaticCalendarDates(@Param("service_id")String service_id);
	int deleteAll();
	StaticCalendarDatesBean getStaticCalendarDates(@Param("service_id")String service_id);
	List<StaticCalendarDatesBean> getStaticCalendarDatesList();
}
