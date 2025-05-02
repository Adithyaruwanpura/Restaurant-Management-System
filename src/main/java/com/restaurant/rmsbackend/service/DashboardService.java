package com.restaurant.rmsbackend.service;
import com.restaurant.rmsbackend.dto.DashboardStatsDTO;
import com.restaurant.rmsbackend.dto.BestSellerDTO;
import com.restaurant.rmsbackend.repository.OrderItemRepository;
import com.restaurant.rmsbackend.repository.OrderRepository;
import com.restaurant.rmsbackend.repository.PaymentRepository;
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



    public DashboardStatsDTO getStats() {
        long totalOrders = orderRepo.count();
        long todayOrders = orderRepo.countTodayOrders();
        double totalRevenue = paymentRepo.getTotalRevenue() != null ? paymentRepo.getTotalRevenue() : 0.0;
        double todayRevenue = paymentRepo.getTodayRevenue() != null ? paymentRepo.getTodayRevenue() : 0.0;

        return DashboardStatsDTO.builder()
                .totalOrders(totalOrders)
                .totalRevenue(totalRevenue)
                .todayOrders(todayOrders)
                .todayRevenue(todayRevenue)
                .build();
    }

    public List<BestSellerDTO> getTopBestSellers(LocalDateTime start, LocalDateTime end) {
        Pageable top5 = (Pageable) PageRequest.of(0, 5);
        return orderItemRepo.findTopSellingItemsBetween(start, end, top5);
    }


    public Map<LocalDate, Double> getDailyRevenue(LocalDate start, LocalDate end) {
        return paymentRepo.findByTimestampBetween(start.atStartOfDay(), end.plusDays(1).atStartOfDay())
                .stream()
                .collect(Collectors.groupingBy(
                        p -> p.getTimestamp().toLocalDate(),
                        Collectors.summingDouble(p -> p.getAmount())
                ));
    }

}
