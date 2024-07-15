package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Product;

public interface ProductRepository {
	List<Product> findAll();
	Product findById(Long Id);
}
