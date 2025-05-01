package com.restaurant.rmsbackend.repository;

import com.restaurant.rmsbackend.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> { }