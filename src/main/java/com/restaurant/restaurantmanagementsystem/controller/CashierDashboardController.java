package com.restaurant.restaurantmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for handling the cashier dashboard view.
 */
@Controller
@RequestMapping("/cashier")
public class CashierDashboardController {

    /**
     * Serves the cashier dashboard view.
     * Maps to: src/main/resources/templates/cashier/dashboard.html
     *
     * @return View name for the cashier dashboard
     */
    @GetMapping("/dashboard")
    public String cashierDashboard() {
        return "cashier/dashboard";
    }
}
