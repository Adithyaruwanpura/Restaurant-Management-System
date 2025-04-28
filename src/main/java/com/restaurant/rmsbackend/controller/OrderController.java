package com.restaurant.rmsbackend.controller;

import com.restaurant.rmsbackend.model.OrderEntity;
import com.restaurant.rmsbackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping("/")
    public List<OrderEntity> get() {
        return service.getAll();
    }

    @PutMapping("/complete/{id}")
    public OrderEntity complete(@PathVariable Long id) {
        return service.complete(id);
    }


}


