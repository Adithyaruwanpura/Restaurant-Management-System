package com.restaurant.rmsbackend.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String contactNumber;

    private LocalDate date;
    private LocalTime time;

    private int numberOfGuests;
    private int tableNumber;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

}

