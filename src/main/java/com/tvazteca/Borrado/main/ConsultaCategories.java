package com.tvazteca.Borrado.main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.tvazteca.Borrado.document.Categories;

public class ConsultaCategories {

	private static final String GET_ALL_CATEGORIES = "https://platform.mediastre.am/api/category";
	static RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) {
		callGetAllCategories();

	}

	private static void callGetAllCategories() {

		HttpHeaders headers = new HttpHeaders();
		//headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	

		Map<String, Object> map = new HashMap<>();
		map.put("X-API-TOKEN", "12022ce044dd12084b5e70c33c05f551");

		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

		ResponseEntity<String> result = restTemplate.exchange(GET_ALL_CATEGORIES, HttpMethod.GET, entity,
				String.class);
		
		
		
		if(result.hasBody()) {
			//System.out.println(result.getBody());
			JSONObject root = new JSONObject(result.getBody());
			
			JSONArray categories = root.getJSONArray("data");
			for(int i = 0; i < categories.length(); i++) {
				JSONObject JCat = categories.getJSONObject(i);
				
				Categories category = new Categories();
				category.set_id(JCat.getString("_id"));
				category.setName(JCat.getString("name"));
				
				category.setParent(JCat.getString("name"));
				category.setType(JCat.getString("name"));
				System.out.println(category.toString());
				
			}
		}
		
		
	}

}
