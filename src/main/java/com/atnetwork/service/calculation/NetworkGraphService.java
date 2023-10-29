/**
 * 
 */
package com.atnetwork.service.calculation;

import org.jgrapht.GraphPath;

import com.atnetwork.entity.StaticStopsBean;
import com.atnetwork.entity.jgrapht.RelationshipEdge;

/**
 * @author weiwei
 * Make the graph of the networks
 */
public interface NetworkGraphService {
	public void buildVerticeWithStops();
	public String getShortestPathDijkstra(String start, String end);
}
