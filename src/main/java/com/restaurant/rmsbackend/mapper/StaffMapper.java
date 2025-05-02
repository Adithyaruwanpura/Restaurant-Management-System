package com.restaurant.rmsbackend.mapper;
import com.restaurant.rmsbackend.dto.StaffDTO;
import com.restaurant.rmsbackend.model.Role;
import com.restaurant.rmsbackend.model.User;

public class StaffMapper {

    public static StaffDTO toDTO(User user) {
        return StaffDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .role(user.getRole().name())
                .active(user.isActive())
                .build();
    }

    public static User toEntity(StaffDTO dto) {
        return User.builder()
                .id(dto.getId())
                .username(dto.getUsername())
                .role(Role.valueOf(dto.getRole()))
                .active(dto.isActive())
                .build();
    }
}
