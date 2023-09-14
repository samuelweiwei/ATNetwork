/**
 * 
 */
package com.atnetwork.service;

import java.io.File;

import org.springframework.stereotype.Service;

import com.atnetwork.utils.StaticGISDatasetAnalyzer;
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
		String pathret = t.readDataToLocalFile();
		//Analyze all the path ret to databases
//		String stopsPath = pathret+File.separator+"stops.txt";
		StaticGISDatasetAnalyzer sta = new StaticGISDatasetAnalyzer();
		String finalstr = sta.readFileContentToDataList(pathret, "stops", "stops");		
		return finalstr;
	}

}
