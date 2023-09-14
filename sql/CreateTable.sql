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


