/**
 * 
 */
package com.atnetwork.dataset;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atnetwork.entity.StaticShapesBean;

/**
 * @author weiwei
 *
 */
public class ShapesAnalyzer implements DataAnalyzer<StaticShapesBean>{
	
	final String[] paramarray = {"shape_id","shape_pt_lat","shape_pt_lon",
							"shape_pt_sequence","shape_dist_traveled"};
	private static Logger logger = LoggerFactory.getLogger(ShapesAnalyzer.class);

	@Override
	public StaticShapesBean analyzedata(String data) {
		// TODO Auto-generated method stub
		if (StringUtils.isBlank(data)) {
			logger.debug("Data input in StaticShapesBean is null, get no data from gtfs static data analyzer");
			return null;
		}
		String[] sary = data.split(",");
		if ((sary.length == 0) || (sary.length != paramarray.length)){
			logger.debug("Data input of shapes is not the right length with the predefined");
			return null;
		}
		StaticShapesBean ssb = new StaticShapesBean();
		ssb.setShape_id(sary[0]);
		ssb.setShape_pt_lat(sary[1]);
		ssb.setShape_pt_lon(sary[2]);
		ssb.setShape_pt_sequence(sary[3]);
		ssb.setShape_dist_traveled(sary[4]);
		return ssb;
	}

}
