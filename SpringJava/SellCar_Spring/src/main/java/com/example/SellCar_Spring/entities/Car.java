package com.example.SellCar_Spring.entities;

import com.example.SellCar_Spring.dtos.CarDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Car {

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
    @Lob
    private Long price;

    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] img;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id" , nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    public CarDTO getCarDTO(){
        CarDTO carDTO = new CarDTO();
        carDTO.setName(name);
        carDTO.setId(id);
        carDTO.setType(type);
        carDTO.setBrand(brand);
        carDTO.setDescription(description);
        carDTO.setReturnedImg(img);
        carDTO.setPrice(price);
        carDTO.setYear(year);
        carDTO.setColor(color);
        carDTO.setSold(sold);
        carDTO.setUserId(user.getId());
        carDTO.setTransmission(transmission);
        return  carDTO;
    }

    public Car(){}

    public Car(Long id, String name, String brand, String type, String transmission, String color, LocalDate year, Boolean sold, String description, Long price, byte[] img) {
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

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
