/**
 * 
 */
package com.atnetwork.service.calculation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atnetwork.entity.StaticRoutesBean;
import com.atnetwork.entity.storage.StorageNode;
import com.atnetwork.entity.storage.StorageRoutes;
import com.atnetwork.entity.storage.StorageUnionStopsBean;
import com.atnetwork.mapper.StaticRoutesMapper;
import com.atnetwork.mapper.UpdateRoutesOperationMapper;

/**
 * @author weiwei
 *
 */
@Service
public class RouteUpdateServiceImpl implements RouteUpdateService {
	
	Logger logger = LoggerFactory.getLogger(RouteUpdateServiceImpl.class);
	
	@Autowired
	UpdateRoutesOperationMapper urom;
	
	@Autowired
	StaticRoutesMapper srm;

	@Override
	public StorageRoutes getUnionStops(String route_id) {
		// TODO Auto-generated method stub
		//First get the stop list
		if (StringUtils.isBlank(route_id)) {
			logger.error("Input route id is null");
			return null;
		}
		List<StorageUnionStopsBean> ret = urom.queryUnionStopsByRouteid(route_id);
		ConcurrentHashMap<String, List<StorageNode>> result = this.collectRoutesDataFromStops(ret);
		StorageRoutes fi = new StorageRoutes();
		StaticRoutesBean srb = srm.getStaticRoutes(route_id);
		fi.setStaticBody(srb);
		fi.setTripUpdates(result);
		return fi;
	}
	
	private ConcurrentHashMap<String, List<StorageNode>> collectRoutesDataFromStops(List<StorageUnionStopsBean> data) {
		if ((data == null) || (data.size() == 0)) {
			logger.error("Input routes for stops data is null");
			return null;
		}
		ConcurrentHashMap<String, List<StorageNode>> ret = new ConcurrentHashMap<>();
		HashSet<String> tripsVisited = new HashSet<>();
		List<StorageNode> swap;
		for(StorageUnionStopsBean susb: data) {
			StorageNode node = new StorageNode(StorageNode.nodetype_stop);
			node.setSusb(susb);
			if (tripsVisited.contains(susb.getTrip_id())) {
				swap = ret.get(susb.getTrip_id());
				swap.add(susb.getStop_sequence()-1, node);
			}else {
				swap = new LinkedList<>();
				swap.add(susb.getStop_sequence()-1,node);
				ret.put(susb.getTrip_id(), swap);
				tripsVisited.add(susb.getTrip_id());
			}
		}
		return ret;		
	}

}
