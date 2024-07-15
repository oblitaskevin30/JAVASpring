package com.example.demo.repository;


import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.model.Product;

@SessionScope
@Repository("ImplRepository")
public class ProductRepositoryImpl implements ProductRepository{

	private List<Product> data;
	
	public ProductRepositoryImpl() {
		this.data = Arrays.asList(
				new Product(1L,"memoria corsarir",25L),
				new Product(2L,"memoria2 corsarir",50L),
				new Product(3L,"memoria3 corsarir",75L),
				new Product(4L,"memoria4 corsarir",90L)
				
				);				
	}
	
	public List<Product> findAll(){
		return data;
	}
	
	public Product findById(Long id) {
		return data.stream().filter(p->p.getId().equals(id)).findFirst().orElse(null);
	}
}
