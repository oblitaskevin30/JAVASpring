package com.example.SellCar_Spring.services.jwt;


import com.example.SellCar_Spring.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService {

    public UserDetailsService userDetailService();

    public Optional<User> findUserByEmail(String email);
}
