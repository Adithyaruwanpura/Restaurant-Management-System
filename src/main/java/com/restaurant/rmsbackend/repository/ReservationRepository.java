package com.restaurant.rmsbackend.repository;

import com.restaurant.rmsbackend.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}

