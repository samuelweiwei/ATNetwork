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
    route_id VARCHAR(256) UNIQUE,
    service_id VARCHAR(256),
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

CREATE TABLE IF NOT EXISTS public.static_stop_times (
    trip_id VARCHAR(256) UNIQUE,
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
)
