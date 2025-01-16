package com.example.SellCar_Spring.services.auth;


import com.example.SellCar_Spring.dtos.SingupRequest;
import com.example.SellCar_Spring.dtos.UserDTO;
import com.example.SellCar_Spring.entities.User;
import com.example.SellCar_Spring.enums.UserRole;
import com.example.SellCar_Spring.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements  AuthService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void createAnAdminAccount(){
        Optional<User> optionalAdmin = userRepository.findByUserRole(UserRole.ADMIN);
        if(optionalAdmin.isEmpty()){

            User admin = new User();
            admin.setName("Admin");
            admin.setEmail("admin@test.com");
            admin.setUserRole(UserRole.ADMIN);
            admin.setPassword(passwordEncoder.encode("admin"));
            userRepository.save(admin);
            System.out.println("admin created");
        } else{
            System.out.println("admin account can not be created because it already exist");
        }
    }

    @Override
    public Boolean hasUserWithEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    @Override
    public UserDTO signup(SingupRequest singupRequest) {

        User user = new User();
        user.setEmail(singupRequest.getEmail());
        user.setUserRole(UserRole.CUSTOMER);
        user.setPassword(passwordEncoder.encode(singupRequest.getPassword()));
        user.setName(singupRequest.getName());
        return userRepository.save(user).getUserDTO();
    }
}
