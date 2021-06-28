package com.tvazteca.Borrado.controller;



import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tvazteca.Borrado.document.Categories;
import com.tvazteca.Borrado.service.CategoriesService;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
	
	
	private CategoriesService categoriesService;
	

	public CategoriesController(CategoriesService categoriesService) {
		this.categoriesService=categoriesService;
	}
	
	
	@RequestMapping("/create")
	public ResponseEntity<List<Categories>> addCategories(){
		return ResponseEntity.ok(categoriesService.addCategories());
	}
	
	public void updateCategories() {}
	
	@GetMapping
	public ResponseEntity<List<Categories>> getAllCategories() {
		return ResponseEntity.ok(categoriesService.getAllCategories());
	}
	
	public void deleteCategories() {}
	

}
