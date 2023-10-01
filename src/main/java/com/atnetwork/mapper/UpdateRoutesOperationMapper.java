/**
 * 
 */
package com.atnetwork.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.atnetwork.entity.storage.StorageUnionStopsBean;
import com.atnetwork.entity.storage.StorageUnionStopsDistBean;

/**
 * @author weiwei
 *
 */
@Mapper
@Repository
public interface UpdateRoutesOperationMapper {
	List<StorageUnionStopsBean> queryUnionStopsByRouteid(@Param("route_id")String route_id);
	List<StorageUnionStopsDistBean> queryUnionStopsDistByRouteid(@Param("route_id")String route_id);
}
