package com.example.SellCar_Spring.services.customer;

import com.example.SellCar_Spring.dtos.AnalyticsDTO;
import com.example.SellCar_Spring.dtos.BidDTO;
import com.example.SellCar_Spring.dtos.CarDTO;
import com.example.SellCar_Spring.dtos.SearchCarDTO;
import com.example.SellCar_Spring.entities.Bid;
import com.example.SellCar_Spring.entities.Car;
import com.example.SellCar_Spring.entities.User;
import com.example.SellCar_Spring.enums.BidStatus;
import com.example.SellCar_Spring.repositories.BidRepository;
import com.example.SellCar_Spring.repositories.CarRepository;
import com.example.SellCar_Spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private BidRepository bidRepository;

    @Override
    public CarDTO getCarById(Long id) {
        Optional<Car> optionalCar = carRepository.findById(id);
        return optionalCar.map(Car::getCarDTO).orElseThrow(null);
    }

    @Override
    public boolean createCar(CarDTO carDTO) throws IOException {
        Optional<User> optionalUSer = userRepository.findById(carDTO.getUserId());
        if (optionalUSer.isPresent()) {
            Car car = new Car();
            car.setName(carDTO.getName());
            car.setBrand(carDTO.getBrand());
            car.setPrice(carDTO.getPrice());
            car.setDescription(carDTO.getDescription());
            car.setColor(carDTO.getColor());
            car.setTransmission(carDTO.getTransmission());
            car.setSold(carDTO.getSold());
            car.setYear(carDTO.getYear());
            car.setImg(carDTO.getImg().getBytes());
            car.setUser(optionalUSer.get());
            car.setType(carDTO.getType());
            carRepository.save(car);
            return true;
        }
        return false;
    }

    @Override
    public List<CarDTO> getAllCars() {
        return carRepository.findAll().stream().map(Car::getCarDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public boolean updateCar(Long id, CarDTO carDTO) throws IOException {

        Optional<Car> optionalCar = carRepository.findById(id);
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();

            car.setId(carDTO.getId());
            car.setName(carDTO.getName());
            car.setBrand(carDTO.getBrand());
            car.setPrice(carDTO.getPrice());
            car.setDescription(carDTO.getDescription());
            car.setColor(carDTO.getColor());
            car.setTransmission(carDTO.getTransmission());

            car.setYear(carDTO.getYear());
            if (carDTO.getImg() != null) {
                car.setImg(carDTO.getImg().getBytes());
            }

            car.setType(carDTO.getType());

            carRepository.save(car);
            return true;
        }
        return false;
    }

    @Override
    public List<CarDTO> searchcar(SearchCarDTO searchCarDTO) {
        Car car = new Car();
        car.setType(searchCarDTO.getType());
        car.setColor(searchCarDTO.getColor());
        car.setTransmission(searchCarDTO.getTransmission());
        car.setBrand(searchCarDTO.getBrand());
        System.out.println(car.toString());

        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll()
                .withMatcher("brand", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("type", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("color", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("transmission", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

        Example<Car> carExample = Example.of(car, exampleMatcher);

        List<Car> cars = carRepository.findAll(carExample);
        return cars.stream().map(Car::getCarDTO).collect(Collectors.toList());
    }

    @Override
    public List<CarDTO> getMyCars(Long userId) {
        return carRepository.findAllByUserId(userId).stream().map(Car::getCarDTO).collect(Collectors.toList());
    }

    @Override
    public boolean bidACar(BidDTO bidDTO) {
        Optional<Car> optionalCar = carRepository.findById(bidDTO.getCarId());
        Optional<User> optionalUser = userRepository.findById(bidDTO.getUserId());
        if (optionalCar.isPresent() && optionalUser.isPresent()) {
            Bid bid = new Bid();
            bid.setUser(optionalUser.get());
            bid.setCar(optionalCar.get());
            bid.setPrice(bidDTO.getPrice());
            bid.setBidStatus(BidStatus.PENDING);
            bidRepository.save(bid);
            return true;
        }
        return false;
    }


    @Override
    public ResponseEntity<Map<String, Object>> getMyBidsByUser(Long userId) {
        List<BidDTO> bidList = bidRepository.findAllByUserId(userId).stream().map(Bid::getBidDTO).collect(Collectors.toList());
        Map<String, Object> response = new HashMap<>();
        if (!bidList.isEmpty()) {
            response.put("mensaje", "Bids list by user");
            response.put("status", HttpStatus.OK);
            response.put("fecha", new Date());
            response.put("BidsByUserId", bidList);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            response.put("mensaje", "Bids list by user");
            response.put("status", HttpStatus.NOT_FOUND);
            response.put("fecha", new Date());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }


    }

    @Override
    public ResponseEntity<Map<String, Object>> getBidsByCarId(Long carId) {
        List<BidDTO> bidList = bidRepository.findAllByCarId(carId).stream().map(Bid::getBidDTO).collect(Collectors.toList());
        Map<String, Object> response = new HashMap<>();
        if (!bidList.isEmpty()) {
            response.put("mensaje", "listamos bids por Car id ");
            response.put("status", HttpStatus.OK);
            response.put("fecha", new Date());
            response.put("BidsByCarId", bidList);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            response.put("mensaje", "Lista de Bids by car");
            response.put("status", HttpStatus.NOT_FOUND);
            response.put("fecha", new Date());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @Override
    public ResponseEntity<Map<String, Object>> changeBidStatus(Long bidId, String status) {
        Optional<Bid> optionalBid = bidRepository.findById(bidId);
        Map<String , Object> response = new HashMap<>();
        if(optionalBid.isPresent()){
            Bid bid = optionalBid.orElseThrow();
            if(bid.getCar().getSold()){
                response.put("mensaje" , "la unidad ya se esta vendida");
                response.put("valorAutoVendido", true);
                return ResponseEntity.status(HttpStatus.OK).build();
            }

            if(Objects.equals(status, "Approved")){
                bid.setBidStatus(BidStatus.APPROVED);
                response.put("mensaje" , "se cambio status a APROVED , se vendio el auto con id : " + bid.getCar().getId().toString());
                response.put("bid", bid.getBidDTO());
                bidRepository.save(bid);
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }else{
                bid.setBidStatus(BidStatus.REJECTEC);
                response.put("mensaje" , "Se cambio status a REJECTED");
                response.put("bid", bid.getBidDTO());
                bidRepository.save(bid);
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }

        }

        response.put("mensaje" , "no se Realizo el cambio correctamente");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @Override
    public AnalyticsDTO getsAnalytics(Long userID) {
        System.out.println("get analytics service");
        AnalyticsDTO analyticsDTO =  new AnalyticsDTO();
        analyticsDTO.setTotalCars(carRepository.countByUserId(userID));
        analyticsDTO.setSoldCars(carRepository.countByUserIdAndSoldTrue(userID));
        System.out.println(carRepository.countByUserId(userID));
        System.out.println(carRepository.countByUserIdAndSoldTrue(userID));
        return analyticsDTO;
    }
}
