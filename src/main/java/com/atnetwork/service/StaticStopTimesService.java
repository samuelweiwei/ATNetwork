/**
 * 
 */
package com.atnetwork.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atnetwork.entity.StaticStopTimesBean;

/**
 * @author weiwei
 *
 */
public interface StaticStopTimesService {
	int addStaticStopTimes(StaticStopTimesBean ppb);
	int updateStaticStopTimes(StaticStopTimesBean ppb);
	int deleteStaticStopTimes(@Param("stop_id")String stop_id);
	int deleteStaticsStopTimesAll();
	StaticStopTimesBean getStaticStopTimes(@Param("stop_id")String stop_id);
	List<StaticStopTimesBean> getStaticBeansList();
}
