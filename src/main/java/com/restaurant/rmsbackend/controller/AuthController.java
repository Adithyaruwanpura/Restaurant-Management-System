package com.restaurant.rmsbackend.controller;

import com.restaurant.rmsbackend.dto.LoginRequestDTO;
import com.restaurant.rmsbackend.dto.LoginResponseDTO;
import com.restaurant.rmsbackend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")

public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO request) {
        return authService.login(request);
    }

}
