package com.restaurant.rmsbackend.repository;

import com.restaurant.rmsbackend.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> { }
