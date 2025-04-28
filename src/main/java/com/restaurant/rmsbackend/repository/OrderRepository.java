package com.restaurant.rmsbackend.repository;


import com.restaurant.rmsbackend.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}

