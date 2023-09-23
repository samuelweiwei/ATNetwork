/**
 * 
 */
package com.atnetwork.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atnetwork.entity.StaticRoutesBean;

/**
 * @author weiwei
 *
 */
public interface StaticRoutesService {
	int addStaticRoutes(StaticRoutesBean ppb);
	int batchAddStaticRoutes(List<StaticRoutesBean> ssblist);
	int updateStaticRoutes(StaticRoutesBean ppb);
	int deleteStaticRoutes(@Param("route_id")String route_id);
	int deleteStaticRoutesAll();
	StaticRoutesBean getStaticRoutes(@Param("route_id")String route_id);
	List<StaticRoutesBean> getStaticBeansList();
}
