/**
 * 
 */
package com.atnetwork.dataset;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atnetwork.entity.StaticTripsBean;

/**
 * @author weiwei
 * @param <T>
 *
 */
public class TripsAnalyzer implements DataAnalyzer<StaticTripsBean> {

	final String[] paramarray = {"route_id", "service_id", "trip_id", "trip_headsign",
								"trip_short_name", "direction_id", "block_id", "shape_id",
								"wheelchair_accessible", "bikes_allowed"};
	private static Logger logger = LoggerFactory.getLogger(DataAnalyzer.class);
	private StaticTripsBean stb;
	
	@Override
	public StaticTripsBean analyzedata(String data) {
		// TODO To analyze the row of the static gtfs data
		// The data format would be like csv and the first row is label, from
		// the second row is data
		if (StringUtils.isBlank(data)) {
			logger.debug("Data input in StaticTripsBean is null, get no data from gtfs static data analyzer");
			return null;
		}
		String[] sary = data.split(",");
		if ((sary.length == 0) || (sary.length != paramarray.length)){
			logger.debug("Data input of trips is not the right length with the predefined");
			return null;
		}
		stb = new StaticTripsBean();
		stb.setRoute_id(sary[0]);
		stb.setService_id(sary[1]);
		stb.setTrip_id(sary[2]);
		stb.setTrip_headsign(sary[3]);
		stb.setTrip_short_name(sary[4]);
		stb.setDirection_id(sary[5]);
		stb.setBlock_id(sary[6]);
		stb.setShape_id(sary[7]);
		stb.setWheelchair_accessible(sary[8]);
		stb.setBikes_allowed(sary[9]);
		return stb;
	}

}
