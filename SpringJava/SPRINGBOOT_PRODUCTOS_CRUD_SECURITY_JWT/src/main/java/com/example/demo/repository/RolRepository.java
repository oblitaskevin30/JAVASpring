package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

import com.example.demo.models.Rol;

public interface RolRepository extends CrudRepository<Rol, Long>{
	Optional<Rol> findByName(String name);
}
