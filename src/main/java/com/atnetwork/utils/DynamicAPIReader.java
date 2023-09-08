/**
 * 
 */
package com.atnetwork.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.net.URIBuilder;
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
	
	public final static String default_busroute_url = "https://api.at.govt.nz/realtime/legacy/servicealerts";
	public final static String default_subscription_key = "edc69f77e51446f3be5cb82ecc8191dd";
	
	public DynamicAPIReader() {
		this.apiUrl = default_busroute_url;
	}
	
	public DynamicAPIReader(String apiUrl) {
		if (!StringUtils.isBlank(apiUrl)) {
			this.apiUrl = apiUrl;
		}else {
			this.apiUrl = default_busroute_url;
		}
	}
	
	/**
	 * 
	 * @param param Request param list
	 * @return Response string
	 */
	public String sendGET(HashMap<String, String> param) {
		String result = null;
		HttpGet httpGet = new HttpGet(this.apiUrl);
		List<NameValuePair> nvps = new ArrayList<>();
        // GET Query Parameters
        nvps.add(new BasicNameValuePair("subscription-key", default_subscription_key));
        if ((param != null)  && (param.size() > 0)) {
        	Iterator<String> it = param.keySet().iterator();
        	while (it.hasNext()) {
        		String key = it.next();
        		String value = param.get(key);
        		nvps.add(new BasicNameValuePair(key, value));
        	}
        }
        // Add to the request URL
        try {
            URI uri = new URIBuilder(new URI(this.apiUrl))
                .addParameters(nvps)
                .build();
            httpGet.setUri(uri);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
			try(CloseableHttpResponse resp = httpClient.execute(httpGet)){
				HttpEntity entity = resp.getEntity();
				result= EntityUtils.toString(entity);
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 
	 * @param param request param list
	 * @return Response string
	 */
	public String sendPOST(HashMap<String, String> param) {
        String result = null;
        HttpPost httpPost = new HttpPost(this.apiUrl);
        // form parameters.
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("subscription-key", default_subscription_key));
        if ((param != null)  && (param.size() > 0)) {
        	Iterator<String> it = param.keySet().iterator();
        	while (it.hasNext()) {
        		String key = it.next();
        		String value = param.get(key);
        		nvps.add(new BasicNameValuePair(key, value));
        	}
        }
        httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            try (CloseableHttpResponse response = httpclient.execute(httpPost)) {
//                System.out.println(response.getVersion()); // HTTP/1.1
//                System.out.println(response.getCode()); // 200
//                System.out.println(response.getReasonPhrase()); // OK

                HttpEntity entity = response.getEntity();
                result = EntityUtils.toString(entity);
                // Ensure that the stream is fully consumed
                EntityUtils.consume(entity);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

	public static void main(String[] args) {
		DynamicAPIReader  dar = new DynamicAPIReader();
		String result = dar.sendGET(null);
		System.out.println(result);
	}
	

}
