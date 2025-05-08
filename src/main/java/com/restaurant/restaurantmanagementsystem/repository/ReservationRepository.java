package com.restaurant.restaurantmanagementsystem.repository;
import com.restaurant.restaurantmanagementsystem.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}

