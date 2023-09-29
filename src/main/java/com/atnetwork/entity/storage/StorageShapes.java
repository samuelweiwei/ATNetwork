/**
 * 
 */
package com.atnetwork.entity.storage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

/**
 * @author weiwei
 *
 */
@Component
public class StorageShapes {
	
	private ConcurrentHashMap store = new ConcurrentHashMap();
	private List selectedStops = new ArrayList();
	private Queue selected = new LinkedList();

	public ConcurrentHashMap getStore() {
		return store;
	}

	public void setStore(ConcurrentHashMap store) {
		this.store = store;
	}
	
}
