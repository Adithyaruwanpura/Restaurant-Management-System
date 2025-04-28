package com.restaurant.rmsbackend.service;

import com.restaurant.rmsbackend.model.OrderEntity;
import com.restaurant.rmsbackend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; // ✅ add this
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repo;

    public List<OrderEntity> getAll() {
        return repo.findAll();
    }

    public OrderEntity complete(Long id) {
        OrderEntity o = repo.findById(id).orElseThrow();
        o.setStatus("Completed");
        return repo.save(o);
    }
}


