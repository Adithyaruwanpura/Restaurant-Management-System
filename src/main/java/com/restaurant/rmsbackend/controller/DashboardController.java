package com.restaurant.rmsbackend.controller;
import com.restaurant.rmsbackend.dto.DashboardStatsDTO;
import com.restaurant.rmsbackend.dto.BestSellerDTO;
import com.restaurant.rmsbackend.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/dashboard")
@CrossOrigin("*")

public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/stats")
    public DashboardStatsDTO getStats() {
        return dashboardService.getStats();
    }

    @GetMapping("/bestsellers")
    public List<BestSellerDTO> getTop5Bestsellers(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        return dashboardService.getTopBestSellers(start, end);
    }


    @GetMapping("/daily-revenue")
    public Map<LocalDate, Double> getDailyRevenue(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return dashboardService.getDailyRevenue(start, end);
    }
}
