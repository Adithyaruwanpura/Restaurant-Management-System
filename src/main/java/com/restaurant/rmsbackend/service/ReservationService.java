package com.restaurant.rmsbackend.service;

import com.restaurant.rmsbackend.model.Reservation;
import com.restaurant.rmsbackend.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository repo;

    public List<Reservation> getAll() {
        return repo.findAll();
    }

    public Reservation save(Reservation r) {
        return repo.save(r);
    }
}

