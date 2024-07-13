package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.services.ProductServices;



@RestController
@RequestMapping("/api")
public class SomeController {
	
	private ProductServices productService = new ProductServices();
	
	@GetMapping
	public List<Product> productList(){
		System.out.println("estoy en controller productList");
		return productService.findAll();
	}
	
	@GetMapping("/{id}")
	public Product productId(@PathVariable Long id) {
		System.out.println("estoy en controller FindByID");
		return productService.finById(id);
	}
}
