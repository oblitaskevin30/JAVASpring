package com.example.SellCar_Spring.dtos;

import com.example.SellCar_Spring.enums.UserRole;

public class AuthenticationResponse {

    private String jwt;

    private Long userId ;

    private UserRole userRole;



    public AuthenticationResponse (){}

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
