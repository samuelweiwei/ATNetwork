/**
 * 
 */
package com.atnetwork.service.calculation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atnetwork.entity.StaticRoutesBean;
import com.atnetwork.entity.realtime.RealtimeVehiclePositionsBean;
import com.atnetwork.entity.realtime.RealtimeVehiclePositionsBody;
import com.atnetwork.entity.realtime.RealtimeVehiclePositionsEntity;
import com.atnetwork.entity.storage.StorageNode;
import com.atnetwork.entity.storage.StorageRoutes;
import com.atnetwork.entity.storage.StorageUnionStopsBean;
import com.atnetwork.entity.storage.StorageUnionStopsDistBean;
import com.atnetwork.entity.storage.StorageUnionVehicleBean;
import com.atnetwork.mapper.StaticRoutesMapper;
import com.atnetwork.mapper.UpdateRoutesOperationMapper;
import com.atnetwork.utils.DynamicAPIReader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author weiwei
 *
 */
@Service
public class RouteUpdateServiceImpl implements RouteUpdateService {

	Logger logger = LoggerFactory.getLogger(RouteUpdateServiceImpl.class);

	@Autowired
	UpdateRoutesOperationMapper urom;

	@Autowired
	StaticRoutesMapper srm;

	@Override
	public StorageRoutes getUnionStops(String route_id) {
		// TODO Auto-generated method stub
		// First get the stop list
		if (StringUtils.isBlank(route_id)) {
			logger.error("Input route id is null");
			return null;
		}
		List<StorageUnionStopsBean> ret = urom.queryUnionStopsByRouteid(route_id);
		HashMap<String, LinkedList<StorageNode>> result = this.collectRoutesDataFromStops(ret);
		StorageRoutes fi = new StorageRoutes();
		StaticRoutesBean srb = srm.getStaticRoutes(route_id);
		fi.setStaticBody(srb);
		fi.setTripUpdates(result);
		return fi;
	}

	private HashMap<String, LinkedList<StorageNode>> collectRoutesDataFromStops(
			List<StorageUnionStopsBean> data) {
		if ((data == null) || (data.size() == 0)) {
			logger.error("Input routes for stops data is null");
			return null;
		}
		HashMap<String, LinkedList<StorageNode>> ret = new HashMap<>();
		HashSet<String> tripsVisited = new HashSet<>();
		LinkedList<StorageNode> swap;
		for (StorageUnionStopsBean susb : data) {
			StorageNode node = new StorageNode(StorageNode.nodetype_stop);
			node.setSusb(susb);
			if (tripsVisited.contains(susb.getTrip_id())) {
				swap = ret.get(susb.getTrip_id());
				swap.add(susb.getStop_sequence() - 1, node);
			} else {
				swap = new LinkedList<>();
				swap.add(susb.getStop_sequence() - 1, node);
				ret.put(susb.getTrip_id(), swap);
				tripsVisited.add(susb.getTrip_id());
			}
		}
		return ret;
	}

	@Override
	public StorageRoutes getUnionStopsDist(String route_id) {
		// TODO Auto-generated method stub
		if (StringUtils.isBlank(route_id)) {
			logger.error("Input route id is null");
			return null;
		}

		StorageRoutes fi = new StorageRoutes();
		StaticRoutesBean srb = srm.getStaticRoutes(route_id);
		fi.setStaticBody(srb);
		List<StorageUnionStopsDistBean> ret = urom.queryUnionStopsDistByRouteid(route_id);
		HashMap<String, LinkedList<StorageNode>> stopsresult = this.collectRoutesDataFromStopsDist(ret);
		if ((stopsresult == null) || (stopsresult.size() == 0))
			return null;
		HashMap<String, LinkedList<StorageNode>> vehicleresult = this.getDynamicVechiclePosition();
		if ((vehicleresult == null) || (vehicleresult.size() == 0))
			return null;
		HashMap<String, LinkedList<StorageNode>> combined = this.combineStopsWithVehicles(stopsresult, vehicleresult);
		fi.setTripUpdates(combined);
		return fi;
	}

	/**
	 * Acquire the map with key of trip id, and node of stop
	 * 
	 * @param data stops data from db storage
	 * @return
	 */
	private HashMap<String, LinkedList<StorageNode>> collectRoutesDataFromStopsDist(
			List<StorageUnionStopsDistBean> data) {
		if ((data == null) || (data.size() == 0)) {
			logger.error("Input routes for stops data is null");
			return null;
		}
		HashMap<String, LinkedList<StorageNode>> ret = new HashMap<>();
		HashSet<String> tripsVisited = new HashSet<>();
		LinkedList<StorageNode> swap;
		for (StorageUnionStopsDistBean susb : data) {
			StorageNode node = new StorageNode(StorageNode.nodetype_stop_dist);
			node.setSusdb(susb);
			if (tripsVisited.contains(susb.getTrip_id())) {
				swap = ret.get(susb.getTrip_id());
				System.out.println("Now subs tripid is: "+susb.getTrip_id()+" and its sequence is: "+susb.getStop_sequence());
				System.out.println("Added node sequence is: "+node.getSusdb().getStop_sequence());
//				swap.add(susb.getStop_sequence() - 1, node);
				swap.add(node);
			} else {
				swap = new LinkedList<>();
				swap.add(susb.getStop_sequence() - 1, node);
				ret.put(susb.getTrip_id(), swap);
				tripsVisited.add(susb.getTrip_id());
			}
		}
		for(String key: ret.keySet()) {
			LinkedList<StorageNode> deal = ret.get(key);
			Collections.sort(deal);
		}
		return ret;
	}

	/**
	 * Acquire the map with key of trip id, and node of vehicle
	 * 
	 * @return
	 */
	private HashMap<String, LinkedList<StorageNode>> getDynamicVechiclePosition() {
		// get dynamic code
		DynamicAPIReader dar = new DynamicAPIReader(DynamicAPIReader.default_vehicle_positions_url);
		String apiRet = dar.sendGET(null);
		RealtimeVehiclePositionsBean alertbean = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			alertbean = mapper.readValue(apiRet, RealtimeVehiclePositionsBean.class);
//					System.out.println("json string is: "+JSON.toJSONString(alertbean));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Deal with vehicle position
		if ((alertbean == null) || (alertbean.getResponse() == null) || (alertbean.getResponse().getEntity() == null)
				|| (alertbean.getResponse().getEntity().length == 0)) {
			logger.error("No vehicle position entity, no standard format realtime message");
			return null;
		}
		LinkedList<StorageNode> swap;
		HashSet<String> tripsVisited = new HashSet<>();
		HashMap<String, LinkedList<StorageNode>> ret = new HashMap<>();
		for (RealtimeVehiclePositionsEntity entity : alertbean.getResponse().getEntity()) {
			if (entity.getVehicle() == null)
				continue;
			if (entity.getVehicle().getTrip() == null) // no trip means the vehicle not in operation
				continue;
			StorageNode node = new StorageNode(StorageNode.nodetype_vehicle);
			StorageUnionVehicleBean svb = this.composeBean(entity.getVehicle());
			node.setSvb(svb);
			if (tripsVisited.contains(svb.getTrip_id())) {
				swap = ret.get(svb.getTrip_id());
				swap.add(node);
			} else {
				swap = new LinkedList<>();
				swap.add(node);
				ret.put(svb.getTrip_id(), swap);
				tripsVisited.add(svb.getTrip_id());
			}
		}
		return ret;
	}

	/**
	 * Finish the concurrent hashmap
	 * @param stops
	 * @param vehicles
	 * @return
	 */
	private HashMap<String, LinkedList<StorageNode>> combineStopsWithVehicles(
			HashMap<String, LinkedList<StorageNode>> stops,
			HashMap<String, LinkedList<StorageNode>> vehicles) {
		for (String stripid : stops.keySet()) {
			for (String vtripid : vehicles.keySet()) {
				if (stripid.equalsIgnoreCase(vtripid)) {
					LinkedList<StorageNode> vehiclelist = vehicles.get(vtripid);
					for (StorageNode vnode : vehiclelist) {
						LinkedList<StorageNode> stoplist = stops.get(stripid);
						List<Nodegis> nodegis = new LinkedList<>();
						for (int i = 0; i < stoplist.size(); i++) {
							nodegis.add(new Nodegis(Double.parseDouble(stoplist.get(i).getSusdb().getStop_lat()),
									Double.parseDouble(stoplist.get(i).getSusdb().getStop_lon())));
						}
						int j = 0;
						while (j < stoplist.size()) {
							if ((vnode.getSvb().getLatitude() < Double
									.parseDouble(stoplist.get(j).getSusdb().getStop_lat()))
									&& (j+1 < stoplist.size()) && (vnode.getSvb().getLatitude() < Double
											.parseDouble(stoplist.get(j + 1).getSusdb().getStop_lat()))) {
								break;
							}
							if ((vnode.getSvb().getLatitude() > Double
									.parseDouble(stoplist.get(j).getSusdb().getStop_lat()))
									&& (j+1 < stoplist.size()) && (vnode.getSvb().getLatitude() > Double
											.parseDouble(stoplist.get(j + 1).getSusdb().getStop_lat()))) {
								break;
							}
							
							if ((vnode.getSvb().getLatitude() > Double
									.parseDouble(stoplist.get(j).getSusdb().getStop_lat()))
									&& (j+1 < stoplist.size()) && (vnode.getSvb().getLatitude() < Double
											.parseDouble(stoplist.get(j + 1).getSusdb().getStop_lat()))) {
								stoplist.add(j+1, vnode);
								break;
							}
							if ((vnode.getSvb().getLatitude() < Double
									.parseDouble(stoplist.get(j).getSusdb().getStop_lat()))
									&& (j+1 < stoplist.size()) && (vnode.getSvb().getLatitude() > Double
											.parseDouble(stoplist.get(j + 1).getSusdb().getStop_lat()))) {
								stoplist.add(j+1, vnode);
								break;
							}
							j++;
						}
					}
				}
			}
		}
		return stops;
	}

	private StorageUnionVehicleBean composeBean(RealtimeVehiclePositionsBody body) {
		if (body == null) {
			logger.error("Compose bean with null input of vehicle position response body");
			return null;
		}
		StorageUnionVehicleBean svb = new StorageUnionVehicleBean();
		svb.setId(body.getVehicle().getId());
		svb.setLabel(body.getVehicle().getLabel());
		svb.setLatitude(body.getPosition().getLatitude());
		svb.setLicense_plate(body.getVehicle().getLicense_plate());
		svb.setLongitude(body.getPosition().getLongitude());
		svb.setRoute_id(body.getTrip().getRoute_id());
		svb.setSchedule_relationship(body.getTrip().getSchedule_relationship());
		svb.setSpeed(body.getPosition().getSpeed());
		svb.setStart_date(body.getTrip().getStart_date());
		svb.setStart_time(body.getTrip().getStart_time());
		svb.setTrip_id(body.getTrip().getTrip_id());
		svb.setOccupancy_status(body.getOccupancy_status());
		return svb;
	}

	class Nodegis {
		private double latitude;
		private double longitude;

		public Nodegis(double latitude, double longitude) {
			this.latitude = latitude;
			this.longitude = longitude;
		}

		public double getLatitude() {
			return latitude;
		}

		public void setLatitude(double latitude) {
			this.latitude = latitude;
		}

		public double getLongitude() {
			return longitude;
		}

		public void setLongitude(double longitude) {
			this.longitude = longitude;
		}

	}

}
