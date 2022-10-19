package me.zakaria.billingmicroservice.DTOS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.zakaria.billingmicroservice.entities.Customer;

import java.math.BigDecimal;

@Data @NoArgsConstructor @AllArgsConstructor
public class InvoiceResponseDTO {
    private String id;
    private BigDecimal amount;
    private String clientId;
    private Customer customer;
}
