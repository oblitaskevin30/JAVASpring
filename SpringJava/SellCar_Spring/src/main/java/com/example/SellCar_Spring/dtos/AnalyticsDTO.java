package com.example.SellCar_Spring.dtos;

public class AnalyticsDTO {

    private Long totalCars;
    private Long soldCars;

    public AnalyticsDTO(){}

    public AnalyticsDTO(Long totalCars, Long soldCars) {
        this.totalCars = totalCars;
        this.soldCars = soldCars;
    }

    public Long getTotalCars() {
        return totalCars;
    }

    public void setTotalCars(Long totalCars) {
        this.totalCars = totalCars;
    }

    public Long getSoldCars() {
        return soldCars;
    }

    public void setSoldCars(Long soldCars) {
        this.soldCars = soldCars;
    }
}
