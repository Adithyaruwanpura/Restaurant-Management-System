package com.restaurant.restaurantmanagementsystem.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DashboardStatsDTO {
    private long totalOrders;
    private double totalRevenue;
    private long todayOrders;
    private double todayRevenue;
    private long activeStaff;

}