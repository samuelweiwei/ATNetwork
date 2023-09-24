/**
 * 
 */
package com.atnetwork.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.atnetwork.entity.StaticShapesBean;
import com.atnetwork.mapper.StaticShapesMapper;

/**
 * @author weiwei
 *
 */
public class StaticShapesServiceImpl implements StaticShapesService {

	@Autowired
	StaticShapesMapper shapesMapper;
	
	private Logger logger = LoggerFactory.getLogger(StaticShapesServiceImpl.class);
	
	@Override
	public int addStaticShapes(StaticShapesBean ppb) {
		// TODO Auto-generated method stub
		if (ppb == null) {
			logger.error("Input static shapes bean is null");
			return 0;
		}
		return shapesMapper.addStaticShapes(ppb);
	}

	@Override
	public int batchAddStaticShapes(List<StaticShapesBean> ssblist) {
		// TODO Auto-generated method stub
		if ((ssblist == null) || (ssblist.size() == 0)) {
			logger.error("Input static shapes list is null");
			return 0;
		}
		return shapesMapper.batchAddStaticShapes(ssblist);
	}

	@Override
	public int deleteStaticShapes(String shape_id) {
		// TODO Auto-generated method stub
		if (StringUtils.isBlank(shape_id)) {
			logger.error("Input shape id is null");
			return 0;
		}
		return shapesMapper.deleteStaticShapes(shape_id);
	}

	@Override
	public int deleteStaticShapesAll() {
		// TODO Auto-generated method stub
		return shapesMapper.deleteAll();
	}

	@Override
	public StaticShapesBean getStaticShapes(String shape_id) {
		// TODO Auto-generated method stub
		if (StringUtils.isBlank(shape_id)) {
			logger.error("Input shape id is null");
			return null;
		}
		return shapesMapper.getStaticShapes(shape_id);
	}

	@Override
	public List<StaticShapesBean> getStaticBeansList() {
		// TODO Auto-generated method stub
		return shapesMapper.getStaticShapesList();
	}

	@Override
	public int getRecordsCount() {
		// TODO Auto-generated method stub
		return shapesMapper.getRecordsCount();
	}

}
