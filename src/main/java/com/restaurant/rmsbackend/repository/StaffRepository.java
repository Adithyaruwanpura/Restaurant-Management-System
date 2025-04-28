package com.restaurant.rmsbackend.repository;

import com.restaurant.rmsbackend.model.Staff;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Long> {
}

