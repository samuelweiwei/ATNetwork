/**
 * 
 */
package com.atnetwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atnetwork.entity.StaticRoutesBean;
import com.atnetwork.service.StaticRoutesService;

/**
 * @author weiwei
 *
 */
@RestController(value="/staticroutes")
public class GTFSRoutesController {
	
	@Autowired
	private StaticRoutesService routeService;
	
	@GetMapping(value="/allroutes")
	public ResultEntity<List<StaticRoutesBean>> getStaticStops(){
		ResultEntity<List<StaticRoutesBean>> ret = new ResultEntity<>();
		List<StaticRoutesBean> result = this.routeService.getStaticBeansList();
		if ((result != null) && (result.size() != 0)) {
			ret.setResult(ResultEntity.result_succeeded);
			ret.setData(result);
			ret.setRemarks("All routes records included");
			return ret;
		}
		ret.setRemarks(ResultEntity.result_failed);
		return ret;
	}
}
