package com.tvazteca.Borrado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tvazteca.Borrado.repository.CategoriesRepository;

@SpringBootApplication
public class BorradoApplication {
	
	@Autowired
	private CategoriesRepository CategoriesRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BorradoApplication.class, args);
	}

}
