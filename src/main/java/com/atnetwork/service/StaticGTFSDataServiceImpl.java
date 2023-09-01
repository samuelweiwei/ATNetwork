/**
 * 
 */
package com.atnetwork.service;

import org.springframework.stereotype.Service;

import com.atnetwork.utils.StaticGISDatasetReader;

/**
 * @author weiwei
 *
 */
@Service
public class StaticGTFSDataServiceImpl implements StaticGTFSDataService {

	@Override
	public String startDownloadLatestGTFS() {
		// TODO Auto-generated method stub
		StaticGISDatasetReader t = new StaticGISDatasetReader();
		String ret = t.readDataToLocalFile();
		return ret;
	}

}
