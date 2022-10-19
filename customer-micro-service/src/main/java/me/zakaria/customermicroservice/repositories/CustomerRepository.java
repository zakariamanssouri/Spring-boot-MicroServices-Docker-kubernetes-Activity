package me.zakaria.customermicroservice.repositories;

import me.zakaria.customermicroservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
