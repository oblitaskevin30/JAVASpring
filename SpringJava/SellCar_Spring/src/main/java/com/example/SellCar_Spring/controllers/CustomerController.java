package com.example.SellCar_Spring.controllers;

import com.example.SellCar_Spring.dtos.BidDTO;
import com.example.SellCar_Spring.dtos.CarDTO;
import com.example.SellCar_Spring.dtos.SearchCarDTO;

import com.example.SellCar_Spring.services.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.*;


@RestController
@RequestMapping("/api/customer")
@CrossOrigin(origins = "*")
public class CustomerController {


    @Autowired
    private CustomerService customerService;

    public CustomerController(){
        System.out.println("customer controller");
    }


    @PostMapping("/car")
    public ResponseEntity<?> addCar(@ModelAttribute CarDTO carDTO) throws IOException {
        System.out.println("add car customer controller");
        boolean success = customerService.createCar(carDTO);
        if(success) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/car/{id}")
    public ResponseEntity<?> updateCar(@PathVariable Long id,@ModelAttribute CarDTO carDTO) throws IOException {
        System.out.println("updateCar customer controller");
        boolean success = customerService.updateCar(id, carDTO);
        if(success) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/cars")
    public ResponseEntity<List<CarDTO>> getAllCars(){
        return ResponseEntity.ok(customerService.getAllCars());
    }


    @GetMapping("/car/{id}")
    public ResponseEntity<CarDTO> getCarByid(@PathVariable Long id){
        return ResponseEntity.ok(customerService.getCarById(id));
    }


    @DeleteMapping("/car/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id ){
        customerService.deleteCar(id);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/car/search")
    public ResponseEntity<List<CarDTO>> searchCar(@RequestBody SearchCarDTO searchCarDTO){
        return ResponseEntity.ok(customerService.searchcar(searchCarDTO));
    }


    @GetMapping("/my-cars/{userId}")
    public ResponseEntity<List<CarDTO>> getMyCars(@PathVariable Long userId){
        return ResponseEntity.ok(customerService.getMyCars(userId));
    }

    @PostMapping("/car/bid")
    public ResponseEntity<?> bidACar(@RequestBody BidDTO bidDTO){
        boolean success = customerService.bidACar(bidDTO);
        if(success){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/car/bids/{userId}")
    public ResponseEntity<Map<String , Object>> getMyBidsByUser(@PathVariable Long userId){
        return customerService.getMyBidsByUser(userId);
    }


    @GetMapping("/car/{carId}/bids")
    public ResponseEntity<Map<String , Object>> getBidsByCarId(@PathVariable Long carId){
        return customerService.getBidsByCarId(carId);
    }

    @GetMapping("/car/bid/{bidId}/{status}")
    public ResponseEntity<Map<String, Object>> changeBidStatus(@PathVariable Long bidId, @PathVariable String status){
        return customerService.changeBidStatus(bidId, status);
    }

    @GetMapping("/car/analytics/{userId}")
    public ResponseEntity<?> getAnalytics(@PathVariable Long userId){
        System.out.println("get analytics");
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getsAnalytics(userId));
    }



}
