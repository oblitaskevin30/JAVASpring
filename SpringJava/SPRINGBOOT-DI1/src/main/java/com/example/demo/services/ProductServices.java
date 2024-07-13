package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;



public class ProductServices {
	
	ProductRepository productRepository = new ProductRepository();
	
	public List<Product> findAll(){
		
//		return productRepository.findAll().stream().map(p->{
//			p.setPrice(p.getPrice()+100);
//			return p;
//		})
//		.collect(Collectors.toList());
		return productRepository.findAll();
	}
	
	public Product finById(Long id) {
		return productRepository.findById(id);
	}
	
	
}
