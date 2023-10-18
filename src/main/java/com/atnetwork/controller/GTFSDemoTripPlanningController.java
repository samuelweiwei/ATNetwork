/**
 * 
 */
package com.atnetwork.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson2.JSON;
import com.atnetwork.entity.StaticRoutesBean;
import com.atnetwork.entity.StaticStopsBean;
import com.atnetwork.entity.storage.StorageNode;
import com.atnetwork.entity.storage.StorageRoutes;
import com.atnetwork.service.calculation.NetworkGraphService;
import com.atnetwork.service.calculation.RouteUpdateService;

/**
 * @author weiwei
 *
 */
@RestController(value="/demo")
public class GTFSDemoTripPlanningController {

	@Autowired
	RouteUpdateService rus;
	
	@Autowired
	NetworkGraphService graphServ;
	
	@GetMapping(value="/routestest")
	public ResultEntity<JSONObject> routesTest(@RequestParam(name="routeid")String routeid){
		ResultEntity<JSONObject> ret = new ResultEntity<>();
		StorageRoutes result = rus.getUnionStopsDist(routeid);
		String jsonStr = JSON.toJSONString(result);
		JSONObject obj = JSONObject.parseObject(jsonStr);
		if (result != null) {
			ret.setResult(ResultEntity.result_succeeded);
			ret.setData(obj);
			ret.setRemarks("All stops records included");
			return ret;
		}
		ret.setRemarks(ResultEntity.result_failed);
		ret.setRemarks("Empty dataset or query failed");
		return ret;
	}
	
	@GetMapping(value="/graphtest")
	public ResultEntity<String> graphTest(){
		ResultEntity<String> ret = new ResultEntity<>();
		this.graphServ.buildVerticeWithStops();
		ret.setResult(ResultEntity.result_succeeded);
		ret.setRemarks("Succeed");
		return ret;
	}
	
	
	class StorageRoutesJson implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private StaticRoutesBean staticBody;
		private JSONObject tripUpdates;
		public StaticRoutesBean getStaticBody() {
			return staticBody;
		}
		public void setStaticBody(StaticRoutesBean staticBody) {
			this.staticBody = staticBody;
		}
		public JSONObject getTripUpdates() {
			return tripUpdates;
		}
		public void setTripUpdates(JSONObject tripUpdates) {
			this.tripUpdates = tripUpdates;
		}
	}

}
