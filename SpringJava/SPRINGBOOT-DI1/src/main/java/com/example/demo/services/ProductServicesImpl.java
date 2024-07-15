package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;



@Service
public class ProductServicesImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private Environment enviroment;
	
	
	@Override
	public List<Product> findAll(){	
		
		return productRepository.findAll().stream().map(p->{
			
			Double precioNuevo = p.getPrice()*enviroment.getProperty("config.price.tax", Double.class);
			System.out.println(precioNuevo);
//			Product productoNuevo = new Product(p.getId(),p.getName(),precioNuevo.longValue());
			p.setPrice(precioNuevo.longValue());
			return p;
			})
		.collect(Collectors.toList());

	}
	
	@Override
	public Product findById(Long id) {
		return productRepository.findById(id);
	}

	
	
}
