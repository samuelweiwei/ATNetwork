/**
 * 
 */
package com.atnetwork.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atnetwork.entity.CommonDataType;
import com.atnetwork.utils.StaticGISDatasetAnalyzer;
import com.atnetwork.utils.StaticGISDatasetReader;

/**
 * @author weiwei
 *
 */
@Service
public class StaticGTFSDataServiceImpl implements StaticGTFSDataService {
	
	@Autowired
	StaticGISDatasetAnalyzer sta;

	@Override
	public String startDownloadLatestGTFS() {
		// TODO Auto-generated method stub
		StaticGISDatasetReader t = new StaticGISDatasetReader();
		String pathret = t.readDataToLocalFile();
		//Analyze all the path ret to databases
//		String stopsPath = pathret+File.separator+"stops.txt";
		//Traverse the string array of data types
		StringBuffer finalstr = new StringBuffer();
		for(String type: CommonDataType.datatype_array) {
			finalstr.append(sta.readFileContentToDataList(pathret, type, type));
		}
		return finalstr.toString();
	}

}
