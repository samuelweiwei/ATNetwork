/**
 * 
 */
package com.atnetwork.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atnetwork.entity.StaticRoutesBean;
import com.atnetwork.mapper.StaticRoutesMapper;

/**
 * @author weiwei
 *
 */
@Service
public class StaticRoutesServiceImpl implements StaticRoutesService {
	
	@Autowired
	StaticRoutesMapper srm;
	
	private Logger logger = LoggerFactory.getLogger(StaticRoutesServiceImpl.class);
	

	@Override
	public int addStaticRoutes(StaticRoutesBean ppb) {
		// TODO Auto-generated method stub
		if (ppb == null) {
			logger.error("Input static routes bean is null");
			return 0;
		}	
		return srm.addStaticRoutes(ppb);
	}

	@Override
	public int updateStaticRoutes(StaticRoutesBean ppb) {
		// TODO Auto-generated method stub
		if (ppb == null) {
			logger.error("Input static routes bean is null");
			return 0;
		}	
		return srm.updateStaticRoutes(ppb);
	}

	@Override
	public int deleteStaticRoutes(String route_id) {
		// TODO Auto-generated method stub
		if (StringUtils.isBlank(route_id)) {
			logger.error("Input route id is null");
			return 0;
		}
		return srm.deleteStaticRoutes(route_id);
	}

	@Override
	public StaticRoutesBean getStaticRoutes(String route_id) {
		// TODO Auto-generated method stub
		if (StringUtils.isBlank(route_id)) {
			logger.error("Input route id is null");
			return null;
		}
		return srm.getStaticRoutes(route_id);
	}

	@Override
	public List<StaticRoutesBean> getStaticBeansList() {
		// TODO Auto-generated method stub
		return srm.getStaticRoutesList();
	}

	@Override
	public int deleteStaticRoutesAll() {
		// TODO Auto-generated method stub
		return srm.deleteAll();
	}

}
