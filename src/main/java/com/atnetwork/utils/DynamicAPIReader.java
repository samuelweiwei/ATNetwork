/**
 * 
 */
package com.atnetwork.utils;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import io.micrometer.common.util.StringUtils;

/**
 * @author weiwei
 *
 */
public class DynamicAPIReader {
	
	private String apiUrl;
	private String ret;
	
	public DynamicAPIReader() {		
	}
	
	public DynamicAPIReader(String apiUrl) {
		this.apiUrl = apiUrl;
	}
	
//	public <T> getDataFromApi(String apiUrl) {
//		if (!StringUtils.isBlank(apiUrl)) {
//			this.apiUrl = apiUrl;
//		}
//		
//		RestTemplate rt = new RestTemplate();
//		HttpHeaders headers = new HttpHeaders();
//		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
//
//        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
//        ResponseEntity<?> result =
//                rt.exchange(this.apiUrl, HttpMethod.GET, entity, returnClass);
//        return result.getBody();
//	}
	
	

}
