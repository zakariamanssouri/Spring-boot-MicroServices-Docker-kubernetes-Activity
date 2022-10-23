package me.zakaria.billingmicroservice;

import me.zakaria.billingmicroservice.DTOS.InvoiceRequestDTO;
import me.zakaria.billingmicroservice.exceptions.CustomerNotFoundException;
import me.zakaria.billingmicroservice.services.InvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
@EnableFeignClients
public class BillingMicroServiceApplication {
    public static void main(String[] args)   {
        SpringApplication.run(BillingMicroServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(InvoiceService invoiceService) {
        return  args -> {
        /*
            invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(98717), "C01"));
            invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(546466),"C02"));
			*/
        };
        }
    }
