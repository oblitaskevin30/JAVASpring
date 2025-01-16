package com.example.SellCar_Spring.dtos;

import com.example.SellCar_Spring.enums.BidStatus;

public class BidDTO {

    private Long id;

    private Long price;

    private BidStatus bidStatus;

    private Long userId;

    private Long carId;

    private String userName;
    private  String carName;
    private String carBrand;
    private String email;

    private  String sellerName;


    public BidDTO(){}

    public BidDTO(Long id, Long price, BidStatus bidStatus, Long userId, Long carId) {
        this.id = id;
        this.price = price;
        this.bidStatus = bidStatus;
        this.userId = userId;
        this.carId = carId;
    }

    public BidDTO(Long id, Long price, BidStatus bidStatus, Long userId, Long carId, String userName, String carName, String carBrand, String email, String sellerName) {
        this.id = id;
        this.price = price;
        this.bidStatus = bidStatus;
        this.userId = userId;
        this.carId = carId;
        this.userName = userName;
        this.carName = carName;
        this.carBrand = carBrand;
        this.email = email;
        this.sellerName = sellerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public BidStatus getBidStatus() {
        return bidStatus;
    }

    public void setBidStatus(BidStatus bidStatus) {
        this.bidStatus = bidStatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
}
