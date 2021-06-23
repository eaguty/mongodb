package com.tvazteca.Borrado.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tvazteca.Borrado.document.Users;

public interface UserRepository extends MongoRepository<Users, Integer>{

}
