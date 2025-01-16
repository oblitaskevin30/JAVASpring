package com.example.SellCar_Spring.repositories;

import com.example.SellCar_Spring.entities.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BidRepository extends JpaRepository<Bid,Long> {

    public List<Bid> findAllByUserId(Long userId);
    public List<Bid> findAllByCarId(Long carId);
}
