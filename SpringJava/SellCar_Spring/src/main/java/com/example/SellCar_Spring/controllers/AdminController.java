package com.example.SellCar_Spring.controllers;


import com.example.SellCar_Spring.dtos.CarDTO;
import com.example.SellCar_Spring.dtos.SearchCarDTO;
import com.example.SellCar_Spring.services.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private AdminService adminService;


    @GetMapping("/cars")
    public ResponseEntity<List<CarDTO>> getAllCars(){
        return ResponseEntity.ok(adminService.getAllCars());
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<CarDTO> getCarById(@PathVariable Long id){
        return ResponseEntity.ok(adminService.getCarById(id));
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id ){
        adminService.deleteCar(id);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/car/search")
    public ResponseEntity<List<CarDTO>> searchCar(@RequestBody SearchCarDTO searchCarDTO){
        return ResponseEntity.ok(adminService.searchcar(searchCarDTO));
    }

    @GetMapping("/car/bid/{bidId}/{status}")
    public ResponseEntity<Map<String, Object>> changeBidStatus(@PathVariable Long bidId, @PathVariable String status){
        return adminService.changeBidStatus(bidId, status);
    }

}
