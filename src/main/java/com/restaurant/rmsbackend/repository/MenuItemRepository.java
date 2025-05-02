package com.restaurant.rmsbackend.repository;

import com.restaurant.rmsbackend.model.Category;
import com.restaurant.rmsbackend.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

  ;
    List<MenuItem> findByCategory(Category category);
    List<MenuItem> findByAvailableTrue();


}

