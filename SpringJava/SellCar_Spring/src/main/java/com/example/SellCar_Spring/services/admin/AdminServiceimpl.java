package com.example.SellCar_Spring.services.admin;

import com.example.SellCar_Spring.dtos.CarDTO;
import com.example.SellCar_Spring.dtos.SearchCarDTO;
import com.example.SellCar_Spring.entities.Bid;
import com.example.SellCar_Spring.entities.Car;
import com.example.SellCar_Spring.enums.BidStatus;
import com.example.SellCar_Spring.repositories.BidRepository;
import com.example.SellCar_Spring.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AdminServiceimpl implements AdminService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private BidRepository bidRepository;


    @Override
    public List<CarDTO> getAllCars() {
        return carRepository.findAll().stream().map(Car::getCarDTO).collect(Collectors.toList());
    }

    @Override
    public CarDTO getCarById(Long id) {
        Optional<Car> optionalCar = carRepository.findById(id);
        return optionalCar.map(Car :: getCarDTO).orElseThrow(null);
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public List<CarDTO> searchcar(SearchCarDTO searchCarDTO) {
        Car car = new Car();
        car.setType(searchCarDTO.getType());
        car.setColor(searchCarDTO.getColor());
        car.setTransmission(searchCarDTO.getTransmission());
        car.setBrand(searchCarDTO.getBrand());

        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll()
                .withMatcher("brand",ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("type",ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("color",ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("transmission",ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

        Example<Car> carExample = Example.of(car, exampleMatcher) ;

        List <Car> cars = carRepository.findAll(carExample);
        return cars.stream().map(Car :: getCarDTO).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<Map<String, Object>> changeBidStatus(Long bidId, String status) {
        Optional<Bid> optionalBid = bidRepository.findById(bidId);
        Map<String, Object> response = new HashMap<>();
        if (optionalBid.isPresent()) {
            Bid bid = optionalBid.orElseThrow();
            if (status.equals("Approved")) {
                bid.setBidStatus(BidStatus.APPROVED);
                response.put("mensaje", "Cambio el status a Aprobado");
                response.put("status", HttpStatus.OK);
                response.put("valorCambiado", true);
                response.put("fecha", new Date());
                response.put("BidCambiado", bid);
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } else {
                bid.setBidStatus(BidStatus.REJECTEC);
                response.put("mensaje", "Cambio el status a Rejected");
                response.put("status", HttpStatus.OK);
                response.put("valorCambiado", false);
                response.put("fecha", new Date());
                response.put("BidCambiado", bid);
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }
        }
        response.put("mensaje", "error en el bidId o status ingresados");
        response.put("status", HttpStatus.BAD_REQUEST);
        response.put("fecha", new Date());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
