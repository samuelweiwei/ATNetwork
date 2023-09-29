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
	
	@GetMapping(value="/stopcounts")
	public ResultEntity<List<StaticStopsBean>> getStaticStopsCount(){
		ResultEntity<List<StaticStopsBean>> ret = new ResultEntity<>();
		int count = this.stopService.getRecordsCount();
		ret.setResult(ResultEntity.result_succeeded);
		ret.setRemarks("The number shows the data records");		
		Integer cnt = count;
		ret.setErrorcode(cnt.toString());
		return ret;
	}
	
	@GetMapping(value="/allstops")
	public ResultEntity<List<StaticStopsBean>> getStaticStops(){
		ResultEntity<List<StaticStopsBean>> ret = new ResultEntity<>();
		List<StaticStopsBean> result = this.stopService.getStaticBeansList();
		if ((result != null) && (result.size() != 0)) {
			ret.setResult(ResultEntity.result_succeeded);
			ret.setData(result);
			ret.setRemarks("All stops records included");
			return ret;
		}
		ret.setRemarks(ResultEntity.result_failed);
		return ret;
	}
	
	
}
