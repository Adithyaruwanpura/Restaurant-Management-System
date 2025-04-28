package com.restaurant.rmsbackend.repository;

import com.restaurant.rmsbackend.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}

