package com.restaurant.rmsbackend.controller;


import com.restaurant.rmsbackend.dto.OrderDTO;
import com.restaurant.rmsbackend.model.OrderStatus;
import com.restaurant.rmsbackend.service.AdminReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin("*")
public class AdminReportController {

    @Autowired
    private AdminReportService reportService;

    @GetMapping("/orders")
    public List<OrderDTO> getOrderHistory(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end,
            @RequestParam("status") OrderStatus status) {
        return reportService.getOrderHistory(start, end, status);
    }
}