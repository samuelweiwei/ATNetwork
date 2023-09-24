/**
 * 
 */
package com.atnetwork.dataset;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atnetwork.entity.StaticStopTimesBean;

/**
 * @author weiwei
 *
 */
public class StopTimesAnalyzer implements DataAnalyzer<StaticStopTimesBean> {

	final String[] paramarray = {"trip_id","arrival_time","departure_time",
			"stop_id","stop_sequence","stop_headsign","pickup_type",
			"drop_off_type","shape_dist_traveled","timepoint"};
	private static Logger logger = LoggerFactory.getLogger(StopTimesAnalyzer.class);
	@Override
	public StaticStopTimesBean analyzedata(String data) {
		// TODO Auto-generated method stub
		if (StringUtils.isBlank(data)) {
			logger.debug("Data input in StaticStopTimesBean is null, get no data from gtfs static data analyzer");
			return null;
		}
		String[] sary = data.split(",");
		if ((sary.length == 0) || (sary.length != paramarray.length)){
			logger.debug("Data input of stop times is not the right length with the predefined");
			return null;
		}
		StaticStopTimesBean sstb = new StaticStopTimesBean();
		sstb.setTrip_id(sary[0]);
		sstb.setArrival_time(sary[1]);
		sstb.setDeparture_time(sary[2]);
		sstb.setStop_id(sary[3]);
		sstb.setStop_sequence(sary[4]);
		sstb.setStop_headsign(sary[5]);
		sstb.setPickup_type(sary[6]);
		sstb.setDrop_off_type(sary[7]);
		sstb.setShape_dist_traveled(sary[8]);
		sstb.setTimepoint(sary[9]);
		return sstb;
	}

}
