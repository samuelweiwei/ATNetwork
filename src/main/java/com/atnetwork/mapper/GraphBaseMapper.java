/**
 * 
 */
package com.atnetwork.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.atnetwork.entity.jgrapht.GraphQueryTripRouteBean;

/**
 * @author weiwei
 *
 */
@Mapper
@Repository
public interface GraphBaseMapper {
	public List<GraphQueryTripRouteBean> queryRouteTrips();
}
