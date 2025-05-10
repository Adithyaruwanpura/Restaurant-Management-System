package com.restaurant.restaurantmanagementsystem.controller;

import com.restaurant.restaurantmanagementsystem.dto.BestSellerDTO;
import com.restaurant.restaurantmanagementsystem.dto.DashboardStatsDTO;
import com.restaurant.restaurantmanagementsystem.dto.OrderDTO;
import com.restaurant.restaurantmanagementsystem.repository.OrderRepository;
import com.restaurant.restaurantmanagementsystem.service.DashboardService;
import com.restaurant.restaurantmanagementsystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminDashboardController {



    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "admin/dashboard";
    }

    }





