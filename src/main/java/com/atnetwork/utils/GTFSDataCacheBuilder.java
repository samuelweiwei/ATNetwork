/**
 * 
 */
package com.atnetwork.utils;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import io.micrometer.common.util.StringUtils;


/**
 * @author weiwei
 *
 */
public class GTFSDataCacheBuilder {
	
	
	
	public static int cachecounter = 0;
	private static HashMap<String, Cache<String, DataStorageObject>> referrer= new HashMap<String, Cache<String, DataStorageObject>>();
	private static Logger logger = LoggerFactory.getLogger(GTFSDataCacheBuilder.class);
	
	public GTFSDataCacheBuilder() {
		
	}
	
	public static Cache<String, DataStorageObject> getNewCacheInstance() {
		Cache<String, DataStorageObject> cache = Caffeine.newBuilder()
				  .expireAfterWrite(1, TimeUnit.MINUTES)
				  .maximumSize(100)
				  .build();
		cachecounter++;
		return cache;
	}
	
	public void addRefer(Cache<String, DataStorageObject> cache, String hook) {
		if ((cache == null) || (StringUtils.isBlank(hook))){
			logger.debug("Input cache object or hook is null");
			return;
		}
		referrer.put(hook, cache);
	}

	public static HashMap<String, Cache<String, DataStorageObject>> getReferrer() {
		return referrer;
	}

	public static void setReferrer(HashMap<String, Cache<String, DataStorageObject>> referrer) {
		GTFSDataCacheBuilder.referrer = referrer;
	}
}
