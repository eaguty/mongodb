package com.tvazteca.Borrado.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.tvazteca.Borrado.document.Categories;
import com.tvazteca.Borrado.document.ParentCategories;

@SpringBootApplication
public class ConsultaCategories {

	
	static RestTemplate restTemplate = new RestTemplate();
	private static final String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	private static final String appConfigPath = rootPath + "app.properties";
	
	private static final Properties appProps = new Properties();
	
	

	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		callGetAllCategories();
	}
	
	

	private static void callGetAllCategories() throws FileNotFoundException, IOException {
		
		appProps.load(new FileInputStream(appConfigPath));
		String token= appProps.getProperty("app.mediastream.noticias.token");
		String uri= appProps.getProperty("app.mediastream.api.categoria");
		String GET_ALL_CATEGORIES = uri+"?token="+token;
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	

		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

		ResponseEntity<String> result = restTemplate.exchange(GET_ALL_CATEGORIES, HttpMethod.GET, entity, String.class);
		
		
		
		if(result.hasBody()) {
			JSONObject root = new JSONObject(result.getBody());
			
			JSONArray categories = root.getJSONArray("data");
			System.out.println(categories);
			for(int i = 0; i < categories.length(); i++) {
				JSONObject JCat = categories.getJSONObject(i);
				
				Categories category = new Categories();
				category.set_id(JCat.getString("_id"));
				category.setName(JCat.getString("name"));
				category.setDate_created(JCat.getString("date_created"));
				
				if(JCat.has("parent")) {
					if(!JCat.isNull("parent")){
						JSONObject parent = JCat.getJSONObject("parent");
						ParentCategories parentCategories = new ParentCategories(parent.getString("_id"), parent.getString("name"), parent.getString("date_created"));
						category.setParent(parentCategories);
					}
					else {
						category.setParent(null);
					}
				}
				System.out.println(category);

				
				
			}
		}
		
		
	}

}
