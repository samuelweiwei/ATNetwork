/**
 * 
 */
package com.atnetwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atnetwork.entity.StaticStopsBean;
import com.atnetwork.entity.storage.StorageRoutes;
import com.atnetwork.service.calculation.RouteUpdateService;

/**
 * @author weiwei
 *
 */
@RestController(value="/demo")
public class GTFSDemoTripPlanningController {

	@Autowired
	RouteUpdateService rus;
	
	@GetMapping(value="/routestest")
	public ResultEntity<StorageRoutes> routesTest(@RequestParam(name="routeid")String routeid){
		ResultEntity<StorageRoutes> ret = new ResultEntity<>();
		StorageRoutes result = rus.getUnionStops(routeid);
		if (result != null) {
			ret.setResult(ResultEntity.result_succeeded);
			ret.setData(result);
			ret.setRemarks("All stops records included");
			return ret;
		}
		ret.setRemarks(ResultEntity.result_failed);
		return ret;
	}

}
