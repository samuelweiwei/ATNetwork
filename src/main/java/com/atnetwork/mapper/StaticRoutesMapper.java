/**
 * 
 */
package com.atnetwork.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.atnetwork.entity.StaticRoutesBean;

/**
 * @author weiwei
 *
 */
@Mapper
@Repository
public interface StaticRoutesMapper {
	int addStaticRoutes(@Param("ppb")StaticRoutesBean ppb);
	int batchAddStaticRoutes(@Param("ssblist")List<StaticRoutesBean> ssblist);
	int updateStaticRoutes(@Param("ppb")StaticRoutesBean ppb);
	int deleteStaticRoutes(@Param("route_id")String route_id);
	int deleteAll();
	StaticRoutesBean getStaticRoutes(@Param("route_id")String route_id);
	List<StaticRoutesBean> getStaticRoutesList();
}
