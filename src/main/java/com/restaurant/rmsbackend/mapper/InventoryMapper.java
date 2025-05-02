package com.restaurant.rmsbackend.mapper;

import com.restaurant.rmsbackend.dto.InventoryItemDTO;
import com.restaurant.rmsbackend.model.InventoryItem;

public class InventoryMapper {
    public static InventoryItemDTO toDTO(InventoryItem item) {
        return InventoryItemDTO.builder()
                .id(item.getId())
                .name(item.getName())
                .quantity(item.getQuantity())
                .threshold(item.getThreshold())
                .build();
    }


    public static InventoryItem toEntity(InventoryItemDTO dto) {
        return InventoryItem.builder()
                .id(dto.getId())
                .name(dto.getName())
                .quantity(dto.getQuantity())
                .threshold(dto.getThreshold())
                .build();
    }
}