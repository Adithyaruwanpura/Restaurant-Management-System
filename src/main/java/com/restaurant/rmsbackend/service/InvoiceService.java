package com.restaurant.rmsbackend.service;
import com.restaurant.rmsbackend.dto.InvoiceDTO;
import com.restaurant.rmsbackend.mapper.InvoiceMapper;
import com.restaurant.rmsbackend.model.Invoice;
import com.restaurant.rmsbackend.model.Order;
import com.restaurant.rmsbackend.model.Payment;
import com.restaurant.rmsbackend.repository.InvoiceRepository;
import com.restaurant.rmsbackend.repository.OrderRepository;
import com.restaurant.rmsbackend.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepo;

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private PaymentRepository paymentRepo;

    public List<InvoiceDTO> getAllInvoices() {
        return invoiceRepo.findAll().stream()
                .map(InvoiceMapper::toDTO)
                .collect(Collectors.toList());
    }

    public InvoiceDTO generateInvoice(Long orderId, Long paymentId) {
        Order order = orderRepo.findById(orderId).orElseThrow();
        Payment payment = paymentRepo.findById(paymentId).orElseThrow();

        Invoice invoice = Invoice.builder()
                .order(order)
                .payment(payment)
                .totalAmount(payment.getAmount())
                .issuedAt(LocalDateTime.now())
                .build();

        return InvoiceMapper.toDTO(invoiceRepo.save(invoice));
    }

}
