package me.zakaria.customermicroservice;

import me.zakaria.customermicroservice.dto.CustomerRequestDTO;
import me.zakaria.customermicroservice.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerMicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerMicroServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerService customerService) {
        return args -> {
            customerService.saveCustomer(new CustomerRequestDTO("C01","zakaria","zakaria@gmail.com"));
            customerService.saveCustomer(new CustomerRequestDTO("C02","ahmed","ahmed@gmail.com"));
        };
    }
}
