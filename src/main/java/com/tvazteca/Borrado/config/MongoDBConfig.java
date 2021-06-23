package com.tvazteca.Borrado.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.tvazteca.Borrado.repository.UserRepository;
import com.tvazteca.Borrado.document.Users;


@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class MongoDBConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository) {
		return strings -> {
					userRepository.save(new Users(1, "nam", "Development", 3000L));
					userRepository.save(new Users(2, "Sam", "Operations", 2000L));
				};
						
				
			}
	
}
