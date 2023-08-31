/**
 * 
 */
package com.atnetwork.dataset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atnetwork.utils.DataStorageObject;
import com.atnetwork.utils.GTFSDataCacheBuilder;
import com.github.benmanes.caffeine.cache.Cache;

/**
 * @author weiwei
 * @param <T>
 *
 */
public class TripAnalyzer implements DataAnalyzer<Cache<String, DataStorageObject>> {

	final String[] paramarray = {"route_id", "service_id", "trip_id", "trip_headsign",
								"trip_short_name", "direction_id", "block_id", "shape_id",
								"wheelchair_accessible", "bikes_allowed"};
	private static Logger logger = LoggerFactory.getLogger(DataAnalyzer.class);
	
	@Override
	public Cache<String, DataStorageObject> analyzedata(String[] data) {
		// TODO To analyze the row of the static gtfs data
		// The data format would be like csv and the first row is label, from
		// the second row is data
		if ((data == null) || (data.length == 0)) {
			logger.debug("Data input is null, get no data from gtfs static data analyzer");
			return null;
		}
		DataStorageObject dso = DataStorageObject.getInstance();
		for(String dt: data) {
			dso.getData().add(dt);
		}
		Cache<String, DataStorageObject> cache = GTFSDataCacheBuilder.getNewCacheInstance();
		cache.put("trip", dso);
		GTFSDataCacheBuilder.getReferrer().put("trip", cache);
		return cache;
	}

}
