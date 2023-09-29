/**
 * 
 */
package com.atnetwork.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson2.JSON;
import com.atnetwork.dataset.CalendarAnalyzer;
import com.atnetwork.dataset.CalendarDatesAnalyzer;
import com.atnetwork.dataset.DataAnalyzer;
import com.atnetwork.dataset.RoutesAnalyzer;
import com.atnetwork.dataset.ShapesAnalyzer;
import com.atnetwork.dataset.StopTimesAnalyzer;
import com.atnetwork.dataset.StopsAnalyzer;
import com.atnetwork.dataset.TripsAnalyzer;
import com.atnetwork.entity.StaticCalendarBean;
import com.atnetwork.entity.StaticCalendarDatesBean;
import com.atnetwork.entity.StaticRoutesBean;
import com.atnetwork.entity.StaticShapesBean;
import com.atnetwork.entity.StaticStopTimesBean;
import com.atnetwork.entity.StaticStopsBean;
import com.atnetwork.entity.StaticTripsBean;
import com.atnetwork.mapper.StaticCalendarDatesMapper;
import com.atnetwork.mapper.StaticCalendarMapper;
import com.atnetwork.mapper.StaticRoutesMapper;
import com.atnetwork.mapper.StaticShapesMapper;
import com.atnetwork.mapper.StaticStopTimesMapper;
import com.atnetwork.mapper.StaticStopsMapper;
import com.atnetwork.mapper.StaticTripsMapper;

/**
 * @author weiwei
 *
 */
@Component
public class StaticGISOperation {
	
	@Autowired
	private StaticStopsMapper stopsMapper;
	
	@Autowired
	private StaticTripsMapper tripsMapper;
	
	@Autowired
	private StaticRoutesMapper routesMapper;
	
	@Autowired
	private StaticStopTimesMapper stopTimesMapper;
	
	@Autowired
	private StaticShapesMapper shapesMapper;
	
	@Autowired
	private StaticCalendarMapper calendarMapper;
	
	@Autowired
	private StaticCalendarDatesMapper calDatesMapper;
	
	private static Logger logger = LoggerFactory.getLogger(StaticGISOperation.class);
	
	public void operateStops(String[] arr) {
		String ret = null;
		DataAnalyzer<StaticStopsBean> sb = new StopsAnalyzer();
		List<StaticStopsBean> ssb = new ArrayList<>();
		for(String stop: arr) {
			StaticStopsBean result = sb.analyzedata(stop);
			if (result != null) {
				ssb.add(result);
			}
		}
		if (arr.length != ssb.size()) {
			int sub = arr.length - ssb.size();
			logger.error("There are some dirty data in stops, number is: "+sub);
		}
		stopsMapper.deleteAll();
		//Avoid to big list size
		List<List<StaticStopsBean>> subs = this.partitionList(ssb);
		for(List<StaticStopsBean> sub: subs) {
			stopsMapper.batchAddStaticStops(sub);
		}
//		ret = JSON.toJSONString(ssb);
		return;
	}
	
	public void operateTrips(String[] arr) {
		DataAnalyzer<StaticTripsBean> st = new TripsAnalyzer();
		List<StaticTripsBean> ssb = new ArrayList<>();
		String ret = null;
		for(String trip: arr) {
			StaticTripsBean result = st.analyzedata(trip);
			if (result != null) {
				ssb.add(result);
			}
		}
		if (arr.length != ssb.size()) {
			int sub = arr.length - ssb.size();
			logger.error("There are some dirty data in trips, number is: "+sub);
		}
		tripsMapper.deleteAll();
		//Avoid to big list size
		List<List<StaticTripsBean>> subs = this.partitionList(ssb);
		for(List<StaticTripsBean> sub: subs) {
			tripsMapper.batchAddStaticTrips(sub);
		}
//		ret = JSON.toJSONString(ssb);
		return;
	}
	
	public void operateRoutes(String[] arr) {
		DataAnalyzer<StaticRoutesBean> st = new RoutesAnalyzer();
		List<StaticRoutesBean> ssb = new ArrayList<>();
		String ret = null;
		for(String trip: arr) {
			StaticRoutesBean result = st.analyzedata(trip);
			if (result != null) {
				ssb.add(result);
			}
		}
		if (arr.length != ssb.size()) {
			int sub = arr.length - ssb.size();
			logger.error("There are some dirty data in routes, number is: "+sub);
		}
		routesMapper.deleteAll();
		//Avoid to big list size
		List<List<StaticRoutesBean>> subs = this.partitionList(ssb);
		for(List<StaticRoutesBean> sub: subs) {
			routesMapper.batchAddStaticRoutes(sub);
		}
//		ret = JSON.toJSONString(ssb);
		return;
	}
	
	public void OperateStopTimes(String[] arr) {
		DataAnalyzer<StaticStopTimesBean> st = new StopTimesAnalyzer();
		List<StaticStopTimesBean> ssb = new ArrayList<>();
		String ret = null;
		for(String trip: arr) {
			StaticStopTimesBean result = st.analyzedata(trip);
			if (result != null) {
				ssb.add(result);
			}
		}
		if (arr.length != ssb.size()) {
			int sub = arr.length - ssb.size();
			logger.error("There are some dirty data in stop times, number is: "+sub);
		}
		stopTimesMapper.deleteAll();
		//Avoid to big list size
		List<List<StaticStopTimesBean>> subs = this.partitionList(ssb);
		for(List<StaticStopTimesBean> sub: subs) {
			stopTimesMapper.batchAddStaticStopTimes(sub);
		}
		ret = "successful";
//		ret = JSON.toJSONString(ssb);
		return;
	}
	
	public void operateShapes(String[] arr) {
		DataAnalyzer<StaticShapesBean> st = new ShapesAnalyzer();
		List<StaticShapesBean> ssb = new ArrayList<>();
		String ret = null;
		for(String trip: arr) {
			StaticShapesBean result = st.analyzedata(trip);
			if (result != null) {
				ssb.add(result);
			}
		}
		if (arr.length != ssb.size()) {
			int sub = arr.length - ssb.size();
			logger.error("There are some dirty data in shapes, number is: "+sub);
		}
		shapesMapper.deleteAll();
		//Avoid to big list size
		List<List<StaticShapesBean>> subs = this.partitionList(ssb);
		for(List<StaticShapesBean> sub: subs) {
			shapesMapper.batchAddStaticShapes(sub);
		}
//		ret = JSON.toJSONString(ssb);
		return;
	}

	public void operateCalendar(String[] arr) {
		DataAnalyzer<StaticCalendarBean> st = new CalendarAnalyzer();
		List<StaticCalendarBean> ssb = new ArrayList<>();
		String ret = null;
		for(String trip: arr) {
			StaticCalendarBean result = st.analyzedata(trip);
			if (result != null) {
				ssb.add(result);
			}
		}
		if (arr.length != ssb.size()) {
			int sub = arr.length - ssb.size();
			logger.error("There are some dirty data in calendar, number is: "+sub);
		}
		calendarMapper.deleteAll();
		//Avoid to big list size
		List<List<StaticCalendarBean>> subs = this.partitionList(ssb);
		for(List<StaticCalendarBean> sub: subs) {
			calendarMapper.batchAddStaticCalendar(sub);
		}
//		ret = JSON.toJSONString(ssb);
		return;
	}
	
	public void operateCalendarDates(String[] arr) {
		DataAnalyzer<StaticCalendarDatesBean> st = new CalendarDatesAnalyzer();
		List<StaticCalendarDatesBean> ssb = new ArrayList<>();
		String ret = null;
		for(String trip: arr) {
			StaticCalendarDatesBean result = st.analyzedata(trip);
			if (result != null) {
				ssb.add(result);
			}
		}
		if (arr.length != ssb.size()) {
			int sub = arr.length - ssb.size();
			logger.error("There are some dirty data in calendar dates, number is: "+sub);
		}
		calDatesMapper.deleteAll();
		//Avoid to big list size
		List<List<StaticCalendarDatesBean>> subs = this.partitionList(ssb);
		for(List<StaticCalendarDatesBean> sub: subs) {
			calDatesMapper.batchAddStaticCalendarDates(sub);
		}
//		ret = JSON.toJSONString(ssb);
		return;
	}
	
	/**
	 * Must be version above java 8
	 * @param origin
	 * @return
	 */
	private <T> List<List<T>> partitionList(List<T> origin){
		if ((origin == null) || (origin.size() == 0)) {
			logger.error("Empty list to partition");
			return null;
		}
		int batchcount = 900;
		List<List<T>> subs;
		subs = ListUtils.partition(origin, batchcount);
//		if (origin.size() > 500) {
//			batchcount = (int)Math.ceil(origin.size() / 500);
//			subs = ListUtils.partition(origin, batchcount);
//		}else {
//			subs = ListUtils.partition(origin, batchcount);
//		}		
		return subs;
	}
}
