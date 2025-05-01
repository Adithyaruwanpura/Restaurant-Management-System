package com.restaurant.rmsbackend.mapper;
import com.restaurant.rmsbackend.dto.OrderDTO;
import com.restaurant.rmsbackend.dto.OrderItemDTO;
import com.restaurant.rmsbackend.model.*;
import com.restaurant.rmsbackend.repository.MenuItemRepository;

import java.util.List; import java.util.stream.Collectors;


public class OrderMapper {

    public static Order toEntity(OrderDTO dto, MenuItemRepository menuItemRepo) {
        Order order = Order.builder()
                .id(dto.getId())
                .customerName(dto.getCustomerName())
                .orderType(dto.getOrderType())
                .tableNumber(dto.getTableNumber())
                .status(dto.getStatus())
                .totalPrice(dto.getTotalPrice())
                .createdTime(dto.getCreatedTime())
                .build();

        List<OrderItem> items = dto.getItems().stream().map(i -> {
            MenuItem menuItem = menuItemRepo.findById(i.getMenuItemId()).orElse(null);
            return OrderItem.builder()
                    .menuItem(menuItem)
                    .quantity(i.getQuantity())
                    .itemPrice(i.getItemPrice())
                    .order(order)
                    .build();
        }).collect(Collectors.toList());

        order.setItems(items);
        return order;
    }

    public static OrderDTO toDTO(Order order) {
        List<OrderItemDTO> items = order.getItems().stream().map(i ->
                OrderItemDTO.builder()
                        .menuItemId(i.getMenuItem().getId())
                        .quantity(i.getQuantity())
                        .itemPrice(i.getItemPrice())
                        .build()
        ).collect(Collectors.toList());

        return OrderDTO.builder()
                .id(order.getId())
                .customerName(order.getCustomerName())
                .orderType(order.getOrderType())
                .tableNumber(order.getTableNumber())
                .status(order.getStatus())
                .totalPrice(order.getTotalPrice())
                .createdTime(order.getCreatedTime())
                .items(items)
                .build();
    }

}
