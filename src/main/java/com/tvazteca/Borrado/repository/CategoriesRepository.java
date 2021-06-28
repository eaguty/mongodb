package com.tvazteca.Borrado.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tvazteca.Borrado.document.Categories;

public interface CategoriesRepository extends MongoRepository<Categories, String>{


}
