package com.example.SellCar_Spring.repositories;


import com.example.SellCar_Spring.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findAllByUserId(Long id);

    Long countByUserId(Long userID);

    Long countByUserIdAndSoldTrue(Long userID);
}