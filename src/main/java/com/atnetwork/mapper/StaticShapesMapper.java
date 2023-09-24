/**
 * 
 */
package com.atnetwork.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.atnetwork.entity.StaticShapesBean;

/**
 * @author weiwei
 *
 */
@Repository
@Mapper
public interface StaticShapesMapper {
	int addStaticShapes(@Param("ppb")StaticShapesBean ppb);
	int batchAddStaticShapes(@Param("ssblist")List<StaticShapesBean> ssblist);
	int deleteStaticShapes(@Param("shape_id")String shape_id);
	int deleteAll();
	StaticShapesBean getStaticShapes(@Param("shape_id")String shape_id);
	List<StaticShapesBean> getStaticShapesList();
	int getRecordsCount();
}
