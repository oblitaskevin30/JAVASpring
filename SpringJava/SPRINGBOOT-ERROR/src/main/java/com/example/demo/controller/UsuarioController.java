package com.example.demo.controller;


import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.services.UserService;

@RestController
public class UsuarioController {
	
	@Autowired 
	private UserService userService;
	
	
	@GetMapping("/users")
	public List<User> findAll(){
		return userService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User findById(@PathVariable(name = "id") Long id) {
		
		User user = userService.finById(id).orElseThrow();
				
		return user;
		
	}
}
