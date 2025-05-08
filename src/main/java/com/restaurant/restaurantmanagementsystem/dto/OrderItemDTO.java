package com.restaurant.restaurantmanagementsystem.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class OrderItemDTO {
    private Long menuItemId;
    private int quantity;
    private double itemPrice; }
