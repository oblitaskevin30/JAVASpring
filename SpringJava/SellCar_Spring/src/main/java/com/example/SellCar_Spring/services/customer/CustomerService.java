package com.example.SellCar_Spring.services.customer;

import com.example.SellCar_Spring.dtos.AnalyticsDTO;
import com.example.SellCar_Spring.dtos.BidDTO;
import com.example.SellCar_Spring.dtos.CarDTO;
import com.example.SellCar_Spring.dtos.SearchCarDTO;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface CustomerService {

    CarDTO getCarById(Long id);


    boolean createCar(CarDTO carDTO) throws IOException;

    List<CarDTO> getAllCars();

    void deleteCar( Long id);

    boolean updateCar(Long id ,CarDTO carDTO) throws IOException;

    List<CarDTO> searchcar(SearchCarDTO searchCarDTO);

    List<CarDTO> getMyCars(Long userId);

    boolean bidACar(BidDTO bidDTO);

    ResponseEntity<Map<String,Object>> getMyBidsByUser(Long userId);

    ResponseEntity<Map<String,Object>> getBidsByCarId(Long carId);

    ResponseEntity<Map<String , Object >> changeBidStatus(Long  bidId, String status);

    AnalyticsDTO getsAnalytics(Long userID);
}
