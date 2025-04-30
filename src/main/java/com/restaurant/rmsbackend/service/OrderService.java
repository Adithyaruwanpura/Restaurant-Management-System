package com.restaurant.rmsbackend.service;

import com.restaurant.rmsbackend.model.Order;
import com.restaurant.rmsbackend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; // ✅ add this
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repo;

    public List<Order> getAll() {
        return repo.findAll();
    }

    public Order complete(Long id) {
        Order o = repo.findById(id).orElseThrow();
        o.setStatus("Completed");
        return repo.save(o);
    }
}


