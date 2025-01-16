package com.example.SellCar_Spring.services.auth;


import com.example.SellCar_Spring.dtos.SingupRequest;
import com.example.SellCar_Spring.dtos.UserDTO;


public interface AuthService {

    Boolean hasUserWithEmail(String email);

    UserDTO signup(SingupRequest singupRequest);
}
