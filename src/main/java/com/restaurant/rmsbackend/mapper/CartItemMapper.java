package com.restaurant.rmsbackend.mapper;
import com.restaurant.rmsbackend.dto.CartItemDTO;
import com.restaurant.rmsbackend.model.CartItem; import com.restaurant.rmsbackend.model.MenuItem;
public class CartItemMapper {
    public static CartItemDTO toDTO(CartItem item) {
        return CartItemDTO.builder()
                .id(item.getId())
                .sessionId(item.getSessionId())
                .menuItemId(item.getMenuItem().getId())
                .quantity(item.getQuantity())
                .notes(item.getNotes())
                .build();
    }

    public static CartItem toEntity(CartItemDTO dto, MenuItem menuItem) {
        return CartItem.builder()
                .id(dto.getId())
                .sessionId(dto.getSessionId())
                .menuItem(menuItem)
                .quantity(dto.getQuantity())
                .notes(dto.getNotes())
                .build();
    }

}
