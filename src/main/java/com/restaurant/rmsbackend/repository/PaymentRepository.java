package com.restaurant.rmsbackend.repository;

import com.restaurant.rmsbackend.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> { }