package com.restaurant.restaurantmanagementsystem.repository;

import com.restaurant.restaurantmanagementsystem.model.Order;
import com.restaurant.restaurantmanagementsystem.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCreatedTimeBetweenAndStatus(LocalDateTime start, LocalDateTime end, OrderStatus status);

    @Query
            ("SELECT COUNT(o) FROM Order o WHERE DATE(o.createdTime) = CURRENT_DATE")
    long countTodayOrders();
}
