/**
 * 
 */
package com.atnetwork.entity.storage;

import java.util.HashSet;
import java.util.Set;

/**
 * @author weiwei
 *
 */
public class StoragePathGraph {
	private Set<StoragePathNode> nodes = new HashSet<>();
	
	public void addNode(StoragePathNode node) {
		nodes.add(node);
	}
	
}
