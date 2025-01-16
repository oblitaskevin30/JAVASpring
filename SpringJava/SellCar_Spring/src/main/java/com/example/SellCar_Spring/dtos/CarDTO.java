package com.example.SellCar_Spring.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;


public class CarDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name ;
    private String brand;
    private String type ;
    private String transmission;
    private String color;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate year;
    private Boolean sold;
    private String description;
    private Long price;
    private MultipartFile img;

    private Long userId;
    private byte[] returnedImg;

    public CarDTO(){}
    public CarDTO(Long id, String name, String brand, String type, String transmission, String color, LocalDate year, Boolean sold, String description, Long price, MultipartFile img, Long userId, byte[] returnedImg) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.type = type;
        this.transmission = transmission;
        this.color = color;
        this.year = year;
        this.sold = sold;
        this.description = description;
        this.price = price;
        this.img = img;
        this.userId = userId;
        this.returnedImg = returnedImg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public Boolean getSold() {
        return sold;
    }

    public void setSold(Boolean sold) {
        this.sold = sold;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public byte[] getReturnedImg() {
        return returnedImg;
    }

    public void setReturnedImg(byte[] returnedImg) {
        this.returnedImg = returnedImg;
    }
}
