package com.restaurant.rmsbackend.repository;

import com.restaurant.rmsbackend.model.DiningTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TableRepository extends JpaRepository<DiningTable, Long> {
    Optional<DiningTable> findByTableNumber(int tableNumber);
}
