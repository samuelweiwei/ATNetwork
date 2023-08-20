/**
 * 
 */
package com.atnetwork.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.message.BasicNameValuePair;
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
	
	public final static String default_busroute_url = "";
	
	public DynamicAPIReader() {		
	}
	
	public DynamicAPIReader(String apiUrl) {
		if (!StringUtils.isBlank(apiUrl)) {
			this.apiUrl = apiUrl;
		}else {
			this.apiUrl = default_busroute_url;
		}
	}
	
	public void sendGET() throws IOException {

		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
			HttpGet httpGet = new HttpGet(this.apiUrl);
//		httpGet.addHeader("User-Agent", USER_AGENT);
			CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

			System.out.println("GET Response Status:: " + httpResponse.getCode());

			BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));

			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = reader.readLine()) != null) {
				response.append(inputLine);
			}
			reader.close();

			// print result
			System.out.println(response.toString());
			
			httpClient.close();
		} catch (IOException e) {

		}
	}

	public void sendPOST() throws IOException {

		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
			HttpPost httpPost = new HttpPost(this.apiUrl);
//		httpPost.addHeader("User-Agent", USER_AGENT);

			List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
			urlParameters.add(new BasicNameValuePair("OBJECTID", "Pankaj Kumar"));

			UrlEncodedFormEntity postParams = new UrlEncodedFormEntity(urlParameters);
			httpPost.setEntity(postParams);

			CloseableHttpResponse httpResponse = httpClient.execute(httpPost);

			System.out.println("POST Response Status:: " + httpResponse.getCode());

			BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));

			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = reader.readLine()) != null) {
				response.append(inputLine);
			}
			reader.close();

			// print result
			System.out.println(response.toString());
			httpClient.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
	

}
