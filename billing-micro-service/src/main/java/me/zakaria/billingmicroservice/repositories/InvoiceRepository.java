package me.zakaria.billingmicroservice.repositories;

import me.zakaria.billingmicroservice.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice,String> {
    List<Invoice> findByClientId(String clientId);
}
