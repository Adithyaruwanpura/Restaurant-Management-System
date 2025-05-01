package com.restaurant.rmsbackend.repository;

import com.restaurant.rmsbackend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> { }