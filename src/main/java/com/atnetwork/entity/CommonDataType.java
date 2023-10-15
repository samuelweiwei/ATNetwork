/**
 * 
 */
package com.atnetwork.entity;

/**
 * @author weiwei
 *
 */
public class CommonDataType {
	
	public static final String datatype_agency = "agency";
	public static final String datatype_calendar = "calendar";
	public static final String datatype_fare_dates = "calendar_dates";
	public static final String datatype_fare_attributes = "fare_attributes";
	public static final String datatype_fare_rules = "fare_rules";
	public static final String datatype_feed_info = "feed_info";
	public static final String datatype_frequencies = "frequencies";
	public static final String datatype_routes = "routes";
	public static final String datatype_shapes = "shapes";
	public static final String datatype_stop_times = "stop_times";
	public static final String datatype_stops = "stops";
	public static final String datatype_transfers = "transfers";
	public static final String datatype_trips = "trips";
	public static final String[] datatype_array = {"agency","calendar","calendar_dates","fare_attributes",
													"fare_rules","feed_info","frequencies","routes",
													"shapes","stop_times","stops","transfers","trips"};

	//Empty, Many seats available, Few seats available, Standing room only, Crushed standing room only, Full, Not accepting passengers
	//0,1,2,3,4,5,6 
	public static final byte occupancy_status_empty = 0; 
	public static final byte occupancy_status_manyseats = 1;
	public static final byte occupancy_status_fewseats = 2;
	public static final byte occupancy_status_standingroomonly = 3;
	public static final byte occupancy_status_crushedstandingroom = 4;
	public static final byte occupancy_status_full = 5;
	public static final byte occupancy_status_notaccept = 6;
	
}
