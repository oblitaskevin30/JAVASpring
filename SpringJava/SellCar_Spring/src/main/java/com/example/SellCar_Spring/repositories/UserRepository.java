package com.example.SellCar_Spring.repositories;

import com.example.SellCar_Spring.entities.User;
import com.example.SellCar_Spring.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findByUserRole(UserRole rol);
}
