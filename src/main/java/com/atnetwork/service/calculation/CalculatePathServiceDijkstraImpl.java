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
	
	public static void main(String[] args) {
		CalculatePathService dijkstra = new CalculatePathServiceDijkstraImpl();
		StoragePathNode nodeA= new StoragePathNode("100-56c57897", "Papatoetoe Train Station");
		StoragePathNode nodeB = new StoragePathNode("1002-adf82201", "Stop A Lower Albert");
		StoragePathNode nodeC = new StoragePathNode("1003-ea94d2b2", "1003,Stop B Lower Albert");
		StoragePathNode nodeD = new StoragePathNode("10036-288916d9", "Ellerslie");
		StoragePathNode nodeE = new StoragePathNode("1004-42737000", "Stop C Lower Albert");
		StoragePathNode nodeF = new StoragePathNode("1005-c105552e", "Stop D Lower Albert");		
		StoragePathNode nodeG = new StoragePathNode("1006-3a3acd71", "Stop E Lower Albert");
		
		nodeA.addDestination(nodeB, 10);
		nodeA.addDestination(nodeC, 15);

		nodeB.addDestination(nodeD, 12);
		nodeB.addDestination(nodeF, 15);

		nodeC.addDestination(nodeE, 10);

		nodeD.addDestination(nodeE, 2);
		nodeD.addDestination(nodeF, 1);
		nodeD.addDestination(nodeG, 4);

		nodeF.addDestination(nodeE, 5);
		nodeF.addDestination(nodeG, 2);
		
		StoragePathGraph graph = new StoragePathGraph();
		graph.addNode(nodeA);
		graph.addNode(nodeB);
		graph.addNode(nodeC);
		graph.addNode(nodeD);
		graph.addNode(nodeE);
		graph.addNode(nodeF);
		graph.addNode(nodeG);

		graph = dijkstra.calculateDestPathFromSource(graph, nodeA);
		
	}

}
