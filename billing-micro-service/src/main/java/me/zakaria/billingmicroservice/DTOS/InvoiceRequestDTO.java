package me.zakaria.billingmicroservice.DTOS;

import lombok.*;
import me.zakaria.billingmicroservice.entities.Customer;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;


@Data
@NoArgsConstructor @AllArgsConstructor
public class InvoiceRequestDTO {
    private BigDecimal amount;
    private String clientId;
}
