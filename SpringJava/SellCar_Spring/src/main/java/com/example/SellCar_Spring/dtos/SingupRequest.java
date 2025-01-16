package com.example.SellCar_Spring.dtos;

public class SingupRequest {


    private String email;
    private String password;

    public SingupRequest(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public SingupRequest(){}

    private String name;

    public String getEmail() {
        return email;
    }

    public void setEmai(String emai) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
