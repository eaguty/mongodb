package com.tvazteca.Borrado.service;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tvazteca.Borrado.document.Categories;
import com.tvazteca.Borrado.document.ParentCategories;
import com.tvazteca.Borrado.repository.CategoriesRepository;


@Service
public class CategoriesService {
	@Autowired
	private final CategoriesRepository categoriesRepository;
	private static final String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	private static final String appConfigPath = rootPath + "app.properties";
	private static final Properties appProps = new Properties();
	static RestTemplate restTemplate = new RestTemplate();
	
	public CategoriesService(CategoriesRepository categoriesRepository) {
		this.categoriesRepository=categoriesRepository;
	}

	public List<Categories> addCategories() {
		
		try {
			appProps.load(new FileInputStream(appConfigPath));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		String token= appProps.getProperty("app.mediastream.deportes.token");
		String uri= appProps.getProperty("app.mediastream.api.categoria");
		String GET_ALL_CATEGORIES = uri+"/?token="+token;
		Categories category = new Categories();
		HttpHeaders headers = new HttpHeaders();
		
		List<Categories> listaCategories = new ArrayList<Categories>();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	
		
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

		ResponseEntity<String> result = restTemplate.exchange(GET_ALL_CATEGORIES, HttpMethod.GET, entity, String.class);
		
		if(result.hasBody()) {
			JSONObject root = new JSONObject(result.getBody());
			
			JSONArray categories = root.getJSONArray("data");
			for(int i = 0; i < categories.length(); i++) {
				JSONObject JCat = categories.getJSONObject(i);
				
				
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
				listaCategories.add(category);
				categoriesRepository.save(category);
			}
			
			
		}
		else {
			listaCategories=null;
		}
		return listaCategories;
	}
	
	public void updateCategories() {}
	
	public List<Categories> getAllCategories() {
		return categoriesRepository.findAll();
	}
	
	public void deleteCategories() {}
}
