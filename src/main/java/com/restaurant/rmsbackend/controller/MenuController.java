package com.restaurant.rmsbackend.controller;

import com.restaurant.rmsbackend.model.MenuItem;
import com.restaurant.rmsbackend.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/menu")
@CrossOrigin(origins = "http://localhost:3000")
public class MenuController {

    @Autowired
    private MenuService service;

    @GetMapping("/")
    public List<MenuItem> get() {
        return service.getAll();
    }

    @PostMapping("/")
    public MenuItem post(@RequestBody MenuItem item) {
        return service.save(item);
    }
}

