package com.restaurant.restaurantmanagementsystem.service;
import com.restaurant.restaurantmanagementsystem.dto.DashboardStatsDTO;
import com.restaurant.restaurantmanagementsystem.dto.BestSellerDTO;
import com.restaurant.restaurantmanagementsystem.repository.OrderItemRepository;
import com.restaurant.restaurantmanagementsystem.repository.OrderRepository;
import com.restaurant.restaurantmanagementsystem.repository.PaymentRepository;
import com.restaurant.restaurantmanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DashboardService {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private PaymentRepository paymentRepo;

    @Autowired
    private OrderItemRepository orderItemRepo;

    @Autowired
    private UserRepository userRepo;

    public DashboardStatsDTO getStats() {
        long totalOrders = orderRepo.count();
        long todayOrders = orderRepo.countTodayOrders();
        double totalRevenue = paymentRepo.getTotalRevenue() != null ? paymentRepo.getTotalRevenue() : 0.0;
        double todayRevenue = paymentRepo.getTodayRevenue() != null ? paymentRepo.getTodayRevenue() : 0.0;
        long activeStaff = userRepo.countActiveStaff();

        return DashboardStatsDTO.builder()
                .totalOrders(totalOrders)
                .totalRevenue(totalRevenue)
                .todayOrders(todayOrders)
                .todayRevenue(todayRevenue)
                .activeStaff(activeStaff)
                .build();
    }



    public List<BestSellerDTO> getTopBestSellers(LocalDateTime start, LocalDateTime end) {
        Pageable top5 = (Pageable) PageRequest.of(0, 5);
        return orderItemRepo.findTopSellingItemsBetween(start, end, top5);
    }

    public List<BestSellerDTO> getCurrentTopBestSellers() {
        Pageable top3 = PageRequest.of(0, 3);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime last30Days = now.minusDays(30);
        return orderItemRepo.findTopSellingItemsBetween(last30Days, now, top3);
    }


    public Map<LocalDate, Double> getDailyRevenue(LocalDate start, LocalDate end) {
        return paymentRepo.findByTimestampBetween(start.atStartOfDay(), end.plusDays(1).atStartOfDay())
                .stream()
                .collect(Collectors.groupingBy(
                        p -> p.getTimestamp().toLocalDate(),
                        Collectors.summingDouble(p -> p.getAmount())
                ));
    }
    public List<Object[]> getOrderStatusCounts() {
        return orderRepo.countByStatus(); // Returns List<Object[]: [status, count]
    }

    public List<Object[]> getOrderTypeCounts() {
        return orderRepo.countByOrderType();   // Returns List<Object[]: [orderType, count]
    }




}
