/**
 * 
 */
package com.atnetwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atnetwork.entity.StaticStopsBean;
import com.atnetwork.service.StaticStopsService;

/**
 * @author weiwei
 *
 */
@RestController(value="/staticstops")
public class GTFSStaticStopsController {
	
	@Autowired
	StaticStopsService stopService;
	
	@GetMapping(value="/list")
	public ResultEntity<List<StaticStopsBean>> getStaticStops(){
		ResultEntity<List<StaticStopsBean>> ret = new ResultEntity<>();
		List<StaticStopsBean> result = this.stopService.getStaticBeansList();
		if ((result != null) && (result.size() != 0)) {
			ret.setResult(ResultEntity.result_succeeded);
			ret.setData(result);
			return ret;
		}
		ret.setResult(ResultEntity.result_failed);
		return ret;
	}
}
