/**
 * 
 */
package com.atnetwork.service.calculation;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedMultigraph;
import org.jgrapht.graph.Multigraph;
import org.jgrapht.nio.dot.DOTExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atnetwork.entity.StaticStopsBean;
import com.atnetwork.entity.jgrapht.GraphQueryTripRouteBean;
import com.atnetwork.entity.jgrapht.RelationshipEdge;
import com.atnetwork.mapper.GraphBaseMapper;
import com.atnetwork.mapper.StaticStopTimesMapper;
import com.atnetwork.mapper.StaticStopsMapper;
import com.atnetwork.mapper.StaticTripsMapper;

/**
 * @author weiwei
 *
 */
@Service
public class NetworkGraphServiceImpl implements NetworkGraphService {

	@Autowired
	StaticStopsMapper stopsMapper;
	
	@Autowired
	StaticTripsMapper tripsMapper;
	
	@Autowired
	StaticStopTimesMapper stopTimesMapper;
	
	@Autowired
	GraphBaseMapper graphMapper;
	
	private DirectedMultigraph<StaticStopsBean, RelationshipEdge> graph;
	private Map<String, StaticStopsBean> recorder;
	
	private String pattern = "yyyy-MM-dd-HH-mm-ss";
	private SimpleDateFormat stf = new SimpleDateFormat(pattern);
	
	@Override
	public void buildVerticeWithStops() {
		// TODO Auto-generated method stub
		//Build graphs with stops
		List<StaticStopsBean> allstops = stopsMapper.getStaticStopsList();
		recorder = new HashMap<>();
		graph = new DirectedMultigraph<StaticStopsBean, RelationshipEdge>(
				null, null, false);
		for(StaticStopsBean stop: allstops) {
			graph.addVertex(stop);
			recorder.put(stop.getStop_id(), stop);
		}
		System.out.println("Graps vertex size is:"+graph.vertexSet().size());
		//Search the all trips to the route id
		//The route trips mapping
	    Map<String, String> routeTrips = new HashMap<>();
	    Map<String, List<TripSequenceBean>> tripsStops = new HashMap<>();
	    List<GraphQueryTripRouteBean> routeTripsSeq = graphMapper.queryRouteTrips();
	    for(GraphQueryTripRouteBean item: routeTripsSeq) {
	    	if (!routeTrips.containsKey(item.getTrip_id()))
	    		routeTrips.put(item.getTrip_id(), item.getRoute_id());
	    	if (tripsStops.containsKey(item.getTrip_id())) {
	    		List<TripSequenceBean> swap = tripsStops.get(item.getTrip_id());
	    		TripSequenceBean one = new TripSequenceBean();
	    		one.setStop_id(item.getStop_id());
	    		one.setStop_sequence(item.getStop_sequence());
	    		swap.add(one);
	    	}else {
	    		List<TripSequenceBean> swap = new ArrayList<>();
	    		TripSequenceBean one = new TripSequenceBean();
	    		one.setStop_id(item.getStop_id());
	    		one.setStop_sequence(item.getStop_sequence());
	    		swap.add(one);
	    		tripsStops.put(item.getTrip_id(), swap);
	    	}
	    }
	    System.out.println("trips to routes scale is: "+ routeTripsSeq.size());
	    System.out.println("trips scale is: "+tripsStops.size());
	    //Sort the trips and update the graph
	    for(String trip_id: tripsStops.keySet()) {
	    	List<TripSequenceBean> swap = tripsStops.get(trip_id);
	    	Collections.sort(swap);
	    	for(int i=0;i<swap.size()-1;i++) {
	    		StaticStopsBean source = recorder.get(swap.get(i).getStop_id());
	    		StaticStopsBean dest = recorder.get(swap.get(i+1).getStop_id());
	    		RelationshipEdge edge = null;
	    		if (routeTrips.containsKey(trip_id)) {
	    			edge = new RelationshipEdge(routeTrips.get(trip_id));
	    			graph.addEdge(source, dest, edge);
	    		}else {
	    			edge = new RelationshipEdge(RelationshipEdge.default_label);
	    			graph.addEdge(source, dest, edge);
	    		}
	    		
	    	}
	    }
	    System.out.println("Sorted the trips list and build graph:"+graph.edgeSet().size());
		//match the stopid with stop sequence to add edge
	    DOTExporter<StaticStopsBean, RelationshipEdge> dotExp = new DOTExporter<>();
	    String nowdate = stf.format(new Date());
	    dotExp.exportGraph(graph, new File("dotExp-"+nowdate +".dot"));
	    return;
	    
	}

	
	public GraphPath<StaticStopsBean, RelationshipEdge> getShortestPathDijkstra(String start, String end) {
		DijkstraShortestPath<StaticStopsBean, RelationshipEdge> path = new DijkstraShortestPath<>(graph);
	    StaticStopsBean a = recorder.get("7089-8ec85023");
	    StaticStopsBean g = recorder.get("3864-d00f2924");
	    GraphPath<StaticStopsBean, RelationshipEdge> ret = path.getPath(a, g);
		if (path != null) {
			List<StaticStopsBean> vertices = ret.getVertexList();
			List<RelationshipEdge> edges = ret.getEdgeList();
			if (edges.size() == (vertices.size() - 1)) {
				for (int i = 0; i < vertices.size(); i++) {
					System.out.println(vertices.get(i).getStop_name());
					if (i < (vertices.size() - 1))
						System.out.println(edges.get(i).getLabel());
				}

			}
		}
		return ret;
	}
	
//	@Override
//	public void buildEdgesCrossVertices() {
//		// TODO Auto-generated method stub
//		StaticStopsBean a = new StaticStopsBean();
//		a.setStop_name("a");
//		StaticStopsBean b = new StaticStopsBean();
//		b.setStop_name("b");
//		StaticStopsBean c = new StaticStopsBean();
//		c.setStop_name("c");
//		StaticStopsBean d = new StaticStopsBean();
//		d.setStop_name("d");
//		StaticStopsBean e = new StaticStopsBean();
//		e.setStop_name("e");
//		StaticStopsBean f = new StaticStopsBean();
//		f.setStop_name("f");
//		StaticStopsBean g = new StaticStopsBean();
//		g.setStop_name("g");
//		DirectedMultigraph<StaticStopsBean, DefaultEdge> graph = new DirectedMultigraph<StaticStopsBean, DefaultEdge>(
//				null, null, false);
//		graph.addVertex(a);
//		graph.addVertex(b);
//		graph.addVertex(c);
//		graph.addVertex(d);
//		graph.addVertex(e);
//		graph.addVertex(f);
//		graph.addVertex(g);
//		graph.addEdge(a, b, new DefaultEdge());
//		graph.addEdge(a, c, new DefaultEdge());
//		graph.addEdge(b, d, new DefaultEdge());
//		graph.addEdge(c, e, new DefaultEdge());
//		graph.addEdge(e, f, new DefaultEdge());
//		graph.addEdge(d, f, new DefaultEdge());
//		graph.addEdge(f, g, new DefaultEdge());
//		graph.addEdge(c, f, new DefaultEdge());
//		DijkstraShortestPath<StaticStopsBean, DefaultEdge> path = new DijkstraShortestPath<>(graph);
//		GraphPath<StaticStopsBean, DefaultEdge> ret = path.getPath(a, g);
//		List<StaticStopsBean> vertices = ret.getVertexList();
//		for(StaticStopsBean bean: vertices)
//			System.out.println(bean.getStop_name());
//		
//	}


	/**
	 * Internal class for comparison
	 * @author weiwei
	 *
	 */
	class TripSequenceBean implements Comparable<TripSequenceBean>{
		private String stop_id;
		private int stop_sequence;
		
		public int getStop_sequence() {
			return stop_sequence;
		}
		public void setStop_sequence(int stop_sequence) {
			this.stop_sequence = stop_sequence;
		}

		public String getStop_id() {
			return stop_id;
		}
		public void setStop_id(String stop_id) {
			this.stop_id = stop_id;
		}
		@Override
		public int compareTo(TripSequenceBean o) {
			// TODO Auto-generated method stub
			if (o == null) {
				return -1;
			}
			if (this.getStop_sequence() > o.getStop_sequence()) {
				return 1;
			}else if (this.getStop_sequence() <  o.getStop_sequence()) {
				return -1;
			}
			return 0;
		}
	}
	
	
	public static void main(String[] args) {
		NetworkGraphService serv = new NetworkGraphServiceImpl();
//		serv.buildEdgesCrossVertices();
		serv.buildVerticeWithStops();
	}
}
