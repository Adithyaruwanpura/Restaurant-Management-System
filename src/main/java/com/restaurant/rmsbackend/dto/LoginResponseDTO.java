package com.restaurant.rmsbackend.dto;

import com.restaurant.rmsbackend.model.Role;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class LoginResponseDTO

{ private String message;
    private String username;
    private Role role; }