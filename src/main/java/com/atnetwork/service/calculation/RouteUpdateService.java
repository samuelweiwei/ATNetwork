/**
 * 
 */
package com.atnetwork.service.calculation;

import com.atnetwork.entity.storage.StorageRoutes;

/**
 * @author weiwei
 *
 */
public interface RouteUpdateService {
	public StorageRoutes getUnionStops(String route_id);
	public StorageRoutes getUnionStopsDist(String route_id);
}
