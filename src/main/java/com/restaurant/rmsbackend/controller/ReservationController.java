package com.restaurant.rmsbackend.controller;
import com.restaurant.rmsbackend.dto.ReservationDTO;
import com.restaurant.rmsbackend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@CrossOrigin(origins = "*")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public List<ReservationDTO> getAll() {
        return reservationService.getAllReservations();
    }

    @PostMapping
    public ReservationDTO create(@RequestBody ReservationDTO dto) {
        return reservationService.createReservation(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reservationService.deleteReservation(id);
    }

}


