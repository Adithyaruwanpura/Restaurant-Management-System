package com.restaurant.restaurantmanagementsystem.controller;

import com.restaurant.restaurantmanagementsystem.dto.DashboardStatsDTO;
import com.restaurant.restaurantmanagementsystem.dto.OrderDTO;
import com.restaurant.restaurantmanagementsystem.service.DashboardService;
import com.restaurant.restaurantmanagementsystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminDashboardController {

    @Autowired
    private DashboardService dashboardService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/dashboard")
    public String loadAdminDashboard(Model model) {
        DashboardStatsDTO stats = dashboardService.getStats();
        List<OrderDTO> orders = orderService.getAllOrders();

        model.addAttribute("stats", stats);
        model.addAttribute("orders", orders);

        return "dashboard/admin";
    }
}
