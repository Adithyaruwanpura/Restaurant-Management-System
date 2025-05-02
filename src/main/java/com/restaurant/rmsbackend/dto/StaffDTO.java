package com.restaurant.rmsbackend.dto;
import  com.restaurant.rmsbackend.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StaffDTO {
    private Long id;
    private String username;
    private String role;
    private boolean active;
}

