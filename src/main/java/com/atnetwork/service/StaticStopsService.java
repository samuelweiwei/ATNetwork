/**
 * 
 */
package com.atnetwork.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atnetwork.entity.StaticStopsBean;

/**
 * @author weiwei
 *
 */
public interface StaticStopsService {
	int addStaticStops(StaticStopsBean ppb);
	int updateStaticStops(StaticStopsBean ppb);
	int deleteStaticStops(@Param("stop_id")String stop_id);
	StaticStopsBean getStaticStops(@Param("stop_id")String stop_id);
	List<StaticStopsBean> getStaticBeansList();
}
