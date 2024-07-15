package com.example.demo.repository;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ProductRepositoryJson implements ProductRepository{
	
	private List<Product> listProductosJson;
	
	public ProductRepositoryJson() throws StreamReadException, DatabindException, IOException {
		
		ClassPathResource resource = new ClassPathResource("json/product.json");
		ObjectMapper objectMapper = new ObjectMapper();
		listProductosJson = Arrays.asList(objectMapper.readValue(resource.getInputStream(),Product[].class));
	}
	
	public ProductRepositoryJson(Resource resource) throws StreamReadException, DatabindException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		listProductosJson = Arrays.asList(objectMapper.readValue(resource.getInputStream(),Product[].class));
	}
	
	@Override
	public List<Product> findAll() {
		return listProductosJson;
	}

	@Override
	public Product findById(Long Id) {
		
		return listProductosJson.stream().filter(p-> {
			return p.getId().equals(Id);
					}).findFirst().orElse(null);
	};

}
