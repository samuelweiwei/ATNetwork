/**
 * 
 */
package com.atnetwork.dataset;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atnetwork.entity.StaticCalendarDatesBean;

/**
 * @author weiwei
 *
 */
public class CalendarDatesAnalyzer implements DataAnalyzer<StaticCalendarDatesBean> {
	
	final String[] paramarray = {"service_id","date","exception_type"};
	private static Logger logger = LoggerFactory.getLogger(CalendarDatesAnalyzer.class);
	@Override
	public StaticCalendarDatesBean analyzedata(String data) {
		// TODO Auto-generated method stub
		if (StringUtils.isBlank(data)) {
			logger.debug("Data input in StaticCalendarDatesBean is null, get no data from gtfs static data analyzer");
			return null;
		}
		String[] sary = data.split(",");
		if ((sary.length == 0) || (sary.length != paramarray.length)){
			logger.debug("Data input of calendar_dates is not the right length with the predefined");
			return null;
		}
		StaticCalendarDatesBean scdb = new StaticCalendarDatesBean();
		scdb.setService_id(sary[0]);
		scdb.setDate(sary[1]);
		scdb.setException_type(sary[2]);
		return scdb;
	}

}
