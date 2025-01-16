package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Product> findAll() {
		
		return (List<Product>)productRepository.findAll();
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Product> findById(Long id) {
		
		return productRepository.findById(id);
	}
	
	
	@Override
	@Transactional
	public Product save(Product product) {
		
		return productRepository.save(product);
	}
	
	@Override
	@Transactional
	public Optional<Product> update(Long id, Product product) {
//		we've to see if the product exist in our db 
		Optional<Product> productOptional = productRepository.findById(id);
		System.out.println("este es el producto que vas a actualizar en el service : ");
		System.out.println(productOptional.orElseThrow().toString());
//		try a if sentence to ask if the product is null
		if(productOptional.isPresent()) {
			Product productDb = productOptional.orElseThrow();
			productDb.setName(product.getName());
			productDb.setPrice(product.getPrice());
			productDb.setDescription(product.getDescription());
			
			System.out.println(productDb.toString());
			return Optional.of(productRepository.save(productDb));
		}
		
		return productOptional;
	}
	
	@Override
	@Transactional
	public Optional<Product> delete(Long id) {
		Optional<Product> productOptional = productRepository.findById(id);
		
		productOptional.ifPresent(productDb->{
			productRepository.delete(productDb);
		});
		return productOptional;		
	}




}
