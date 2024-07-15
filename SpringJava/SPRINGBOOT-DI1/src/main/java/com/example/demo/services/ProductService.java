package com.example.demo.services;

import java.util.List;

import com.example.demo.model.Product;

public interface ProductService {
	List<Product> findAll();
	Product findById(Long Id);
}
