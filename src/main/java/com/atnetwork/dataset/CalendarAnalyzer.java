/**
 * 
 */
package com.atnetwork.dataset;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atnetwork.entity.StaticCalendarBean;

/**
 * @author weiwei
 *
 */
public class CalendarAnalyzer implements DataAnalyzer<StaticCalendarBean> {
	final String[] paramarray = {"service_id","monday","tuesday","wednesday","thursday",
			"friday","saturday","sunday","start_date","end_date"};
	private static Logger logger = LoggerFactory.getLogger(CalendarAnalyzer.class);

	@Override
	public StaticCalendarBean analyzedata(String data) {
		// TODO Auto-generated method stub
		if (StringUtils.isBlank(data)) {
			logger.debug("Data input in StaticCalendarBean is null, get no data from gtfs static data analyzer");
			return null;
		}
		String[] sary = data.split(",");
		if ((sary.length == 0) || (sary.length != paramarray.length)){
			logger.debug("Data input of calendar is not the right length with the predefined");
			return null;
		}
		StaticCalendarBean scb = new StaticCalendarBean();
		scb.setService_id(sary[0]);
		scb.setMonday(sary[1]);
		scb.setTuesday(sary[2]);
		scb.setWednesday(sary[3]);
		scb.setThursday(sary[4]);
		scb.setFriday(sary[5]);
		scb.setSaturday(sary[6]);
		scb.setSunday(sary[7]);
		scb.setStart_date(sary[8]);
		scb.setEnd_date(sary[9]);
		return scb;
	}

}
