/**
 * 
 */
package com.atnetwork.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atnetwork.entity.StaticShapesBean;

/**
 * @author weiwei
 *
 */
public interface StaticShapesService {
	int addStaticShapes(StaticShapesBean ppb);
	int batchAddStaticShapes(List<StaticShapesBean> ssblist);
	int deleteStaticShapes(@Param("shape_id")String shape_id);
	int deleteStaticShapesAll();
	StaticShapesBean getStaticShapes(@Param("shape_id")String shape_id);
	List<StaticShapesBean> getStaticBeansList();
	int getRecordsCount();
}
