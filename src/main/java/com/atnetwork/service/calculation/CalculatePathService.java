/**
 * 
 */
package com.atnetwork.service.calculation;

import com.atnetwork.entity.storage.StoragePathGraph;
import com.atnetwork.entity.storage.StoragePathNode;

/**
 * @author weiwei
 *
 */
public interface CalculatePathService {
	public StoragePathGraph calculateDestPathFromSource(StoragePathGraph graph, StoragePathNode source);
}
