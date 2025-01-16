package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Product;


@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {

}
