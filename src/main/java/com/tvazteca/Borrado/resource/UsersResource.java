package com.tvazteca.Borrado.resource;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tvazteca.Borrado.document.Users;
import com.tvazteca.Borrado.repository.UserRepository;

@RestController
@RequestMapping("/rest/users")
public class UsersResource {
	
	private UserRepository userRepository;
	
	public UsersResource(UserRepository userRepository) {
		
		this.userRepository= userRepository;
	}
	
	@GetMapping("/all")
	public List<Users> getAll(){
		return userRepository.findAll();
	}

}
