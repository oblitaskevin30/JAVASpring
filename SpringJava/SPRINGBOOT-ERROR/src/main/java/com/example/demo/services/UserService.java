package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.User;

public interface UserService {
	List<User> findAll();
	Optional<User> finById(Long id);
}
