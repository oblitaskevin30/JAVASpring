package com.example.SellCar_Spring.services.admin;

import com.example.SellCar_Spring.dtos.CarDTO;
import com.example.SellCar_Spring.dtos.SearchCarDTO;
import com.example.SellCar_Spring.enums.BidStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface AdminService {

    List<CarDTO> getAllCars();

    CarDTO getCarById(Long id);

    void deleteCar( Long id);
    List<CarDTO> searchcar(SearchCarDTO searchCarDTO);

    ResponseEntity<Map<String, Object>> changeBidStatus(Long bidId, String status);
}
