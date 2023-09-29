/**
 * 
 */
package com.atnetwork.entity.storage;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.atnetwork.entity.StaticRoutesBean;

/**
 * @author weiwei
 *
 */
public class StorageRoutes {
	private StaticRoutesBean staticBody;
	private ConcurrentHashMap<String, List<StorageNode>> tripUpdates;
	public StaticRoutesBean getStaticBody() {
		return staticBody;
	}
	public void setStaticBody(StaticRoutesBean staticBody) {
		this.staticBody = staticBody;
	}
	public ConcurrentHashMap<String, List<StorageNode>> getTripUpdates() {
		return tripUpdates;
	}
	public void setTripUpdates(ConcurrentHashMap<String, List<StorageNode>> tripUpdates) {
		this.tripUpdates = tripUpdates;
	}	
}
