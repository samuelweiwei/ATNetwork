/**
 * 
 */
package com.atnetwork.dataset;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atnetwork.entity.StaticRoutesBean;

/**
 * @author weiwei
 *
 */
public class RoutesAnalyzer implements DataAnalyzer<StaticRoutesBean> {

	final String[] paramarray = {"route_id","agency_id","route_short_name",
			"route_long_name","route_desc","route_type","route_url","route_color",
			"route_text_color","route_sort_order","contract_id"};
	private static Logger logger = LoggerFactory.getLogger(RoutesAnalyzer.class);
	private StaticRoutesBean srb =  null;
	
	@Override
	public StaticRoutesBean analyzedata(String data) {
		// TODO Auto-generated method stub
		if (StringUtils.isBlank(data)) {
			logger.debug("Data input in StaticRoutesBean is null, get no data from gtfs static data analyzer");
			return null;
		}
		String[] sary = data.split(",");
		if ((sary.length == 0) || (sary.length != paramarray.length)){
			logger.debug("Data input of routes is not the right length with the predefined");
			return null;
		}
		StaticRoutesBean srb = new StaticRoutesBean();
		srb.setRoute_id(sary[0]);
		srb.setAgency_id(sary[1]);
		srb.setRoute_short_name(sary[2]);
		srb.setRoute_long_name(sary[3]);
		srb.setRoute_desc(sary[4]);
		srb.setRoute_type(sary[5]);
		srb.setRoute_url(sary[6]);
		srb.setRoute_color(sary[7]);
		srb.setRoute_text_color(sary[8]);
		srb.setRoute_sort_order(sary[9]);
		srb.setContract_id(sary[10]);
		return srb;
	}

}
