/**
 * 
 */
package com.atnetwork.entity.storage;

import java.util.HashMap;
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
	private HashMap<String, LinkedList<StorageNode>> tripUpdates;
	public StaticRoutesBean getStaticBody() {
		return staticBody;
	}
	public void setStaticBody(StaticRoutesBean staticBody) {
		this.staticBody = staticBody;
	}
	public HashMap<String, LinkedList<StorageNode>> getTripUpdates() {
		return tripUpdates;
	}
	public void setTripUpdates(HashMap<String, LinkedList<StorageNode>> tripUpdates) {
		this.tripUpdates = tripUpdates;
	}	
}
