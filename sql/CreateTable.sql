USE postgres;

CREATE TABLE IF NOT EXISTS public.static_stops (
    stop_id VARCHAR(256) UNIQUE,
    stop_code VARCHAR(256),
    stop_name VARCHAR(128),
    stop_desc VARCHAR(128),
    stop_lat VARCHAR(128),
    stop_lon VARCHAR(128),
    zone_id VARCHAR(128),
    stop_url VARCHAR(128),
    location_type VARCHAR(128),
    parent_station VARCHAR(128),
    stop_timezone VARCHAR(128),
    platform_code VARCHAR(128),
    wheelchair_boarding VARCHAR(128),
    start_date VARCHAR(128),
    end_date VARCHAR(128)
);

CREATE TABLE IF NOT EXISTS public.static_routes (
    route_id VARCHAR(256) UNIQUE,
    agency_id VARCHAR(256),
    route_short_name VARCHAR(128),
    route_long_name VARCHAR(256),
    route_desc VARCHAR(256),
    route_type VARCHAR(128),
    route_url VARCHAR(128),
    route_color VARCHAR(128),
    route_text_color VARCHAR(128),
    route_sort_order VARCHAR(128),
    contract_id VARCHAR(128)
);

CREATE TABLE IF NOT EXISTS public.static_trips (
    route_id VARCHAR(256),
    service_id VARCHAR(256),
    trip_id VARCHAR(256),
    trip_headsign VARCHAR(128),
    trip_short_name VARCHAR(128),
    direction_id VARCHAR(8),
    block_id VARCHAR(128),
    shape_id VARCHAR(256),
    wheelchair_accessible VARCHAR(8),
    bikes_allowed VARCHAR(8)
);

CREATE TABLE IF NOT EXISTS public.static_stop_times (
    trip_id VARCHAR(256),
    arrival_time VARCHAR(128),
    departure_time VARCHAR(128),
    stop_id VARCHAR(256),
    stop_sequence VARCHAR(128),
    stop_headsign VARCHAR(128),
    pickup_type VARCHAR(128),
    drop_off_type VARCHAR(128),
    shape_dist_traveled VARCHAR(128),
    timepoint VARCHAR(128)
);

CREATE TABLE IF NOT EXISTS public.static_calendar (
    service_id VARCHAR(256) UNIQUE,
    monday VARCHAR(8),
    tuesday VARCHAR(8),
    wednesday VARCHAR(8),
    thursday VARCHAR(8),
    friday VARCHAR(8),
    saturday VARCHAR(8),
    sunday VARCHAR(8),
    start_date VARCHAR(128),
    end_date VARCHAR(128)
);

CREATE TABLE IF NOT EXISTS public.static_calendar_dates (
	service_id VARCHAR(256),
	"date" VARCHAR(128),
	exception_type VARCHAR(8)
);

CREATE TABLE IF NOT EXISTS public.static_shapes (
	shape_id VARCHAR(256),
	shape_pt_lat VARCHAR(128),
	shape_pt_lon VARCHAR(128),
	shape_pt_sequence VARCHAR(16),
	shape_dist_traveled VARCHAR(128)
);

CREATE TABLE IF NOT EXISTS public.static_agency (
	agency_id VARCHAR(128) UNIQUE,
	agency_name VARCHAR(128),
	agency_url VARCHAR(256),
	agency_timezone VARCHAR(64),
	agency_lang VARCHAR(32),
	agency_phone VARCHAR(32),
	agency_fare_url VARCHAR(256),
	agency_email VARCHAR(64)
);

CREATE TABLE IF NOT EXISTS public.static_fare_attributes (
	fare_id VARCHAR(256),
	price VARCHAR(32),
	currency_type VARCHAR(16),
	payment_method VARCHAR(64),
	transfers VARCHAR(64),
	agency_id VARCHAR(128),
	transfer_duration VARCHAR(64)
);

CREATE TABLE IF NOT EXISTS public.static_fare_rules (
	fare_id VARCHAR(256),
	route_id VARCHAR(256),
	origin_id VARCHAR(256),
	destination_id VARCHAR(256),
	contains_id VARCHAR(256)
);

CREATE TABLE IF NOT EXISTS public.static_feed_info (
	feed_publisher_name VARCHAR(256), 
	feed_publisher_url VARCHAR(128),
	feed_lang VARCHAR(16),
	feed_start_date VARCHAR(16),
	feed_end_date VARCHAR(16),
	feed_version VARCHAR(128)
);

CREATE TABLE IF NOT EXISTS public.static_frequencies (
	trip_id VARCHAR(256),
	start_time VARCHAR(128),
	end_time VARCHAR(128),
	headway_secs VARCHAR(128),
	exact_times VARCHAR(128)
);

CREATE TABLE IF NOT EXISTS public.static_transfers (
	from_stop_id VARCHAR(256),
	to_stop_id VARCHAR(256),
	transfer_type VARCHAR(16),
	min_transfer_time VARCHAR(128)
)

