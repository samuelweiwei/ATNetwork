/**
 * 
 */
package com.atnetwork.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atnetwork.entity.StaticStopTimesBean;

/**
 * @author weiwei
 *
 */
public interface StaticStopTimesMapper {
	int addStaticStopTimes(@Param("ppb")StaticStopTimesBean ppb);
	int batchAddStaticStopTimes(@Param("ssblist")List<StaticStopTimesBean> ssblist);
	int updateStaticStopTimes(@Param("ppb")StaticStopTimesBean ppb);
	int deleteStaticStopTimes(@Param("stop_id")String stop_id);
	int deleteAll();
	StaticStopTimesBean getStaticStopTimes(@Param("stop_id")String stop_id);
	List<StaticStopTimesBean> getStaticStopTimesList();	
}
