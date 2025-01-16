package com.example.SellCar_Spring.dtos;

public class SearchCarDTO {

    private String brand;

    private String type;

    private String color;

    private String transmission;

    public SearchCarDTO(){}

    public SearchCarDTO(String brand, String type, String color, String transmission) {
        this.brand = brand;
        this.type = type;
        this.color = color;
        this.transmission = transmission;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }
}
