/**
 * 
 */
package com.atnetwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atnetwork.service.StaticGTFSDataService;

import io.micrometer.common.util.StringUtils;

/**
 * @author weiwei
 *
 */
@RestController
public class GFTSController {
	
	@Autowired
	StaticGTFSDataService gtfsServ;
	
	@GetMapping(value="/liveness")
	public String healthTest() {
		return "http server is alive";
	}

	@GetMapping(value="/downloadandupdate")
	public ResultEntity<String> startStaticGTFSDataAcquire() {
		String pathret = this.gtfsServ.startDownloadLatestGTFS();
		ResultEntity<String> ret = new ResultEntity<String>();
		if (StringUtils.isBlank(pathret)) {
			ret.setResult(ResultEntity.result_failed);
			ret.setErrorcode(ResultEntity.common_errorcode);
			ret.setRemarks("Fail to download the static gtfs files due to common exception");
			return ret;
		}
		ret.setResult(ResultEntity.result_succeeded);
		ret.setData(pathret);
		ret.setRemarks("Succeed in getting the gtfs static data");
		return ret;		
	}
}
