/**
 * 
 */
package com.atnetwork.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.atnetwork.entity.StaticStopsBean;

/**
 * @author weiwei
 *
 */
@Mapper
@Repository
public interface StaticStopsMapper {
	int addStaticStops(@Param("ppb")StaticStopsBean ppb);
	int batchAddStaticStops(@Param("ssblist")List<StaticStopsBean> ssblist);
	int updateStaticStops(@Param("ppb")StaticStopsBean ppb);
	int deleteStaticStops(@Param("stop_id")String stop_id);
	int deleteAll();
	StaticStopsBean getStaticStops(@Param("stop_id")String stop_id);
	List<StaticStopsBean> getStaticStopsList();
	int getRecordsCount();
}
