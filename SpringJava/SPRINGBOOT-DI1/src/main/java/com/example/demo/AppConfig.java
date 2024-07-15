package com.example.demo;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.ProductRepositoryJson;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {
	
	@Value("classpath:product.json")
	public Resource resource;
	
	@Primary
	@Bean
	ProductRepository productRepositoryJson() throws StreamReadException, DatabindException, IOException {
		return new ProductRepositoryJson(resource);
	}
}
