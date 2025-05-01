package com.restaurant.rmsbackend.dto;
import com.restaurant.rmsbackend.model.TableStatus;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class DiningTableDTO {
    private Long id;

    private int tableNumber;
    private int capacity;
     private TableStatus status;
}
