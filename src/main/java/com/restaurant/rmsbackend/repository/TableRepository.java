package com.restaurant.rmsbackend.repository;

import com.restaurant.rmsbackend.model.DiningTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<DiningTable, Long> { }
