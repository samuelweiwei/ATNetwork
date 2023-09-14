/**
 * 
 */
package com.atnetwork.dataset;


import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atnetwork.entity.StaticStopsBean;
import com.atnetwork.utils.DataStorageObject;
import com.github.benmanes.caffeine.cache.Cache;

/**
 * @author weiwei
 *
 */
public class StopsAnalyzer implements DataAnalyzer<StaticStopsBean> {

	final String[] paramarray = {"stop_id","stop_code","stop_name","stop_desc","stop_lat","stop_lon",
			"zone_id","stop_url","location_type","parent_station",
			"stop_timezone","platform_code","wheelchair_boarding","start_date","end_date"};
	private static Logger logger = LoggerFactory.getLogger(StopsAnalyzer.class);
	private StaticStopsBean ssb =  null;
	
	@Override
	public StaticStopsBean analyzedata(String data) {
		// TODO Auto-generated method stub
		if (StringUtils.isBlank(data)) {
			logger.debug("Data input in StaticStopsBean is null, get no data from gtfs static data analyzer");
			return null;
		}
		String[] sary = data.split(",");
		if ((sary.length == 0) || (sary.length != paramarray.length)){
			logger.debug("Data input of stops is not the right length with the predefined");
			return null;
		}
		this.ssb = new StaticStopsBean();
		ssb.setStop_id(sary[0]);
		ssb.setStop_code(sary[1]);
		ssb.setStop_name(sary[2]);
		ssb.setStop_desc(sary[3]);
		ssb.setStop_lat(sary[4]);
		ssb.setStop_lon(sary[5]);
		ssb.setZone_id(sary[6]);
		ssb.setStop_url(sary[7]);
		ssb.setLocation_type(sary[8]);
		ssb.setParent_station(sary[9]);
		ssb.setStop_timezone(sary[10]);
		ssb.setPlatform_code(sary[11]);
		ssb.setWheelchair_boarding(sary[12]);
		ssb.setStart_date(sary[13]);
		ssb.setEnd_date(sary[14]);
		return this.ssb;
	}
	
}
