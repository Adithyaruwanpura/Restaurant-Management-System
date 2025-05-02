package com.restaurant.rmsbackend.repository;
import com.restaurant.rmsbackend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);
}