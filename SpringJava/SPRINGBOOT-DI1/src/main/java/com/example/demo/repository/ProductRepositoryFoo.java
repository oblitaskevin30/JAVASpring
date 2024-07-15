package com.example.demo.repository;

import java.util.Collections;
import java.util.List;


import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;


@Repository("FooRepository")
public class ProductRepositoryFoo implements ProductRepository {

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return Collections.singletonList(new Product(1L,"monitor",200L));
	}

	@Override
	public Product findById(Long Id) {
		// TODO Auto-generated method stub
		return new Product(Id,"monitor",200L);
	}

}
