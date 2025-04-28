package com.restaurant.rmsbackend.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*") // allow frontend to call
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        if (username.equals("admin") && password.equals("admin123")) {
            return "admin"; // backend tells: user is admin
        } else if (username.equals("chef") && password.equals("chef123")) {
            return "chef"; // backend tells: user is chef
        } else if (username.equals("cashier") && password.equals("cashier123")) {
            return "cashier"; // backend tells: user is cashier
        } else {
            throw new RuntimeException("Invalid username or password!");
        }
    }
}
