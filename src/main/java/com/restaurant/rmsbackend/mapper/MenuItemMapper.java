package com.restaurant.rmsbackend.mapper;
import com.restaurant.rmsbackend.dto.MenuItemDTO;
import com.restaurant.rmsbackend.model.MenuItem;
import org.springframework.stereotype.Component;

@Component
public class MenuItemMapper {
    public MenuItemDTO toDTO(MenuItem item) {
        return MenuItemDTO.builder()
                .id(item.getId())
                .name(item.getName())
                .category(item.getCategory())
                .price(item.getPrice())
                .description(item.getDescription())
                .available(item.isAvailable())
                .build();
    }

    public MenuItem toEntity(MenuItemDTO dto) {
        return MenuItem.builder()
                .id(dto.getId())
                .name(dto.getName())
                .category(dto.getCategory())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .available(dto.isAvailable())
                .build();
    }

}
