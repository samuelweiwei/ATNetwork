/**
 * 
 */
package com.atnetwork.entity.storage;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author weiwei
 *
 */
public class StoragePathNode {
	private String stopName;
	private String stopid;
	private List<StoragePathNode> shortestPath = new LinkedList<>();
	private Double distance = 0.0;
	private Map<StoragePathNode, Double> adjacentNodes = new HashMap<>();
	
	public void addDesination(StoragePathNode dest, double distance) {
		adjacentNodes.put(dest, distance);
	}
	
	public StoragePathNode(String stopid, String stopName) {
		this.stopid = stopid;
		this.stopName = stopName;
	}

	public String getStopName() {
		return stopName;
	}

	public void setStopName(String stopName) {
		this.stopName = stopName;
	}

	public String getStopid() {
		return stopid;
	}

	public void setStopid(String stopid) {
		this.stopid = stopid;
	}

	public List<StoragePathNode> getShortestPath() {
		return shortestPath;
	}

	public void setShortestPath(List<StoragePathNode> shortestPath) {
		this.shortestPath = shortestPath;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Map<StoragePathNode, Double> getAdjacentNodes() {
		return adjacentNodes;
	}

	public void setAdjacentNodes(Map<StoragePathNode, Double> adjacentNodes) {
		this.adjacentNodes = adjacentNodes;
	}
	
}
