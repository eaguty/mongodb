package com.tvazteca.Borrado.main;


import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class LlenadoAssets {
	
	private static final String GET_ALL_ASSETS="https://platform.mediastre.am/api/media?limit=2&type=video&lite=true";
	
	static RestTemplate restTemplate = new RestTemplate();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		callGetAllAssets();
		
	}
	
	
	private static void callGetAllAssets() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		
		
		
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		
		ResponseEntity<String> result = restTemplate.exchange(GET_ALL_ASSETS, HttpMethod.GET, entity, String.class);
		
		System.out.println(result);
	}

}
