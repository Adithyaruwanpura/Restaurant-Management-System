package com.restaurant.rmsbackend.service;
import org.springframework.stereotype.Service;

import com.restaurant.rmsbackend.model.MenuItem;
import com.restaurant.rmsbackend.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuItemRepository repo;

    public List<MenuItem> getAll() {
        return repo.findAll();
    }

    public MenuItem save(MenuItem item) {
        return repo.save(item);
    }
}

