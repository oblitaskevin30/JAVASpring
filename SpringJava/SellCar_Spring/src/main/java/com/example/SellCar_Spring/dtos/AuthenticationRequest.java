package com.example.SellCar_Spring.dtos;


public class AuthenticationRequest {

    private String email;

    private String password;

    public AuthenticationRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public AuthenticationRequest(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String emaill) {
        this.email = emaill;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AuthenticationRequest{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}


