package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Product;
import com.example.demo.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class Productcontroller {
	
	@Autowired
	ProductService productService;
	
	
	@GetMapping("")
	public List<Product> findall(){
		return productService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> view(@PathVariable(name="id") Long id) {
		Optional<Product> productOptional = productService.findById(id);
		if(productOptional.isPresent()) {
			return ResponseEntity.ok(productOptional.orElseThrow());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Product> create(@Valid @RequestBody Product product){
				
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> update(@PathVariable Long id, @Valid @RequestBody Product product){
		Optional<Product> productOptional=productService.update(id,product);
		if(productOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(productOptional.orElseThrow());
		}
		return ResponseEntity.notFound().build();
		
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete( @PathVariable(name="id") Long id) {

		Optional<Product> productOptional = productService.delete(id);
		if(productOptional.isPresent()) {
			return ResponseEntity.ok(productOptional.orElseThrow());
		}
		return ResponseEntity.notFound().build();
	}
	

}
