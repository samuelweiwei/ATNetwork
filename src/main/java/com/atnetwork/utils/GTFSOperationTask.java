/**
 * 
 */
package com.atnetwork.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import io.micrometer.common.util.StringUtils;

/**
 * @author weiwei
 *
 */
public class GTFSOperationTask implements Runnable {

	private static Logger logger = LoggerFactory.getLogger(GTFSOperationTask.class);

	@Autowired
	private StaticGISOperation gisOper;

	private String datatype;

	private String[] arr;

	public GTFSOperationTask(StaticGISOperation gisOper, String datatype, String[] data) {
		this.gisOper = gisOper;
		this.datatype = datatype;
		this.arr = data;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if ((arr == null) || (arr.length == 0) || StringUtils.isBlank(datatype)) {
			logger.error("Input data or datatype is null");
			return;
		}
		if (gisOper == null) {
			logger.error("Input Operation object is null and in datatype: " + datatype);
			return;
		}
		switch (datatype.trim().toLowerCase()) {
		case "stops":
			gisOper.operateStops(arr);
			break;
		case "trips":
			gisOper.operateTrips(arr);
			break;
		case "routes":
			gisOper.operateRoutes(arr);
			break;
		case "stop_times":
			gisOper.OperateStopTimes(arr);
			break;
		case "shapes":
			gisOper.operateShapes(arr);
			break;
		case "calendar":
			gisOper.operateCalendar(arr);
			break;
		case "calendar_dates":
			gisOper.operateCalendarDates(arr);
			break;
		case "agency":
			break;
		case "feed_info":
			break;
		default:
			break;
		}
	}

}
