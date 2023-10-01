/**
 * 
 */
package com.atnetwork.service.calculation;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import com.atnetwork.entity.storage.StoragePathGraph;
import com.atnetwork.entity.storage.StoragePathNode;

/**
 * @author weiwei
 *
 */
public class CalculatePathServiceDijkstraImpl implements CalculatePathService {

	private Set<StoragePathNode> settled = new HashSet<>();
	private Set<StoragePathNode> unsettled = new HashSet<>();

	@Override
	public StoragePathGraph calculateDestPathFromSource(StoragePathGraph graph, StoragePathNode source) {
		// TODO Auto-generated method stub
		source.setDistance(0.0);

		if (settled != null)
			settled.clear();
		if (unsettled != null)
			unsettled.clear();
		unsettled.add(source);
		while (unsettled.size() > 0) {
			StoragePathNode currentNode = getCloseNode(unsettled);
			for (Map.Entry<StoragePathNode, Double> adjacentPair : currentNode.getAdjacentNodes().entrySet()) {
				StoragePathNode adjacentNode = adjacentPair.getKey();
				double edgeWeight = adjacentPair.getValue();
				if (!settled.contains(adjacentNode)) {
					calculateLowestDistance(adjacentNode, edgeWeight, source);
					unsettled.add(adjacentNode);
				}
			}
			settled.add(currentNode);
		}

		return graph;
	}

	private static StoragePathNode getCloseNode(Set<StoragePathNode> unsettledNodes) {
		StoragePathNode lowNode = null;
		double lowDistance = Double.MAX_VALUE;
		for (StoragePathNode node : unsettledNodes) {
			double nodeDist = node.getDistance();
			if (nodeDist < lowDistance) {
				lowDistance = nodeDist;
				lowNode = node;
			}
		}
		return lowNode;
	}

	private static void calculateLowestDistance(StoragePathNode eval, double edgeweight, StoragePathNode source) {
		double srcDistance = source.getDistance();
		if (srcDistance + edgeweight < eval.getDistance()) {
			eval.setDistance(srcDistance+edgeweight);
			LinkedList<StoragePathNode> shortestPath = new LinkedList<>(source.getShortestPath());
			shortestPath.add(source);
			eval.setShortestPath(shortestPath);
		}
	}

}
