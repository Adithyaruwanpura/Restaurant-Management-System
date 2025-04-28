package com.restaurant.rmsbackend.controller;
import org.springframework.web.bind.annotation.RestController;
import com.restaurant.rmsbackend.model.Reservation;
import com.restaurant.rmsbackend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@CrossOrigin(origins = "http://localhost:3000")
public class ReservationController {

    @Autowired
    private ReservationService service;

    @GetMapping("/")
    public List<Reservation> get() {
        return service.getAll();
    }

    @PostMapping("/")
    public Reservation post(@RequestBody Reservation r) {
        return service.save(r);
    }
}


