package com.example.SellCar_Spring.controllers;

import com.example.SellCar_Spring.dtos.AuthenticationRequest;
import com.example.SellCar_Spring.dtos.AuthenticationResponse;
import com.example.SellCar_Spring.dtos.SingupRequest;
import com.example.SellCar_Spring.dtos.UserDTO;
import com.example.SellCar_Spring.entities.User;
import com.example.SellCar_Spring.services.auth.AuthService;
import com.example.SellCar_Spring.services.jwt.UserService;
import com.example.SellCar_Spring.utils.JWTutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private JWTutil jwTutil;
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;



    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SingupRequest singupRequest){
        if(authService.hasUserWithEmail(singupRequest.getEmail())){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("User already exist");
        }

        UserDTO userDTO = authService.signup(singupRequest);
        if(userDTO == null ){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
        }
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody AuthenticationRequest authenticationRequest){
        System.out.println(authenticationRequest.toString());
        try{
            System.out.println("im try");
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getEmail(),
                            authenticationRequest.getPassword()));
            System.out.println("finish try");
        }catch(BadCredentialsException e){
            throw  new BadCredentialsException("Incorrect username or password");
        }

        final UserDetails userDetails = userService.userDetailService().loadUserByUsername(authenticationRequest.getEmail());
        Optional<User> optionalUser = userService.findUserByEmail(authenticationRequest.getEmail());
        final String jwt = jwTutil.generateToken(userDetails);
        AuthenticationResponse response = new AuthenticationResponse();
        if(optionalUser.isPresent()){
            response.setJwt(jwt);
            response.setUserRole(optionalUser.get().getUserRole());
            response.setUserId(optionalUser.get().getId());

        }
        return  response;
    }
}
