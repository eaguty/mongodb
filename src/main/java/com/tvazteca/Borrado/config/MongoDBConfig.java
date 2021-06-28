package com.tvazteca.Borrado.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.tvazteca.Borrado.repository.CategoriesRepository;
import com.tvazteca.Borrado.document.Categories;


@EnableMongoRepositories(basePackageClasses = Categories.class)
@Configuration
public class MongoDBConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(CategoriesRepository categoriesRepository) { 
		return strings -> {
					//userRepository.save(new Categories(1, "nam", "Development", 3000L));
					//userRepository.save(new Categories(2, "Sam", "Operations", 2000L));
				};
						
				
			}
	 
}
