package com.restaurant.rmsbackend.dto;
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class MenuItemDTO {
private Long id;
private String name;
private String category;
private  double price;
private String description;
private boolean available;
}
