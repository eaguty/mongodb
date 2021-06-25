package com.tvazteca.Borrado.main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class ConsultaMetricas {

private static final String GET_ALL_ASSETS="https://metrics.mdstrm.com/outbound/v1/metric/api/";
	
	static RestTemplate restTemplate = new RestTemplate();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		callGetAllAssets();
		
	}
	
	
	private static void callGetAllAssets() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set("X-API-TOKEN", "7c8ab4f9bf5fd0eebd929f3eeaf1effb");
		
		Map<String, Object> map = new HashMap<>();
		map.put("name", "duration_range_detail");
		map.put("dimension", "content");
		//map.put("body", "A powerful tool for building web apps.");
		String parameters = "{\n"
				+ "    \"name\": \"duration_range_detail\",\n"
				+ "    \"dimension\": [\n"
				+ "        \"content\"\n"
				+ "    ],\n"
				+ "    \"filter\": [\n"
				+ "        {\n"
				+ "            \"name\": \"date\",\n"
				+ "            \"op\": [\n"
				+ "                \">=\",\n"
				+ "                \"<=\"\n"
				+ "            ],\n"
				+ "            \"value\": [\n"
				+ "                \"2021-06-08T13:22:00Z\",\n"
				+ "                \"2021-06-08T19:22:59Z\"\n"
				+ "            ]\n"
				+ "        },\n"
				+ "        {\n"
				+ "            \"name\": \"content_id\",\n"
				+ "            \"value\": [\n"
				+ "                \"60d507770f9f4f083ce908ba\"\n"
				+ "            ],\n"
				+ "            \"logic_op\": \"and\",\n"
				+ "            \"order\": 0\n"
				+ "        },\n"
				+ "        {\n"
				+ "            \"name\": \"content_type\",\n"
				+ "            \"value\": [\n"
				+ "                \"vod\"\n"
				+ "            ],\n"
				+ "            \"order\": \"-1\",\n"
				+ "            \"op\": []\n"
				+ "        }\n"
				+ "    ]\n"
				+ "}";
		
		HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);
		
		ResponseEntity<String> result = restTemplate.exchange(GET_ALL_ASSETS, HttpMethod.POST, entity, String.class);
		
		System.out.println(result);
	}

}