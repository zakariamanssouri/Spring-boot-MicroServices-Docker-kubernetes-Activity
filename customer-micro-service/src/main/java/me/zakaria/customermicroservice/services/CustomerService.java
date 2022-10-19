package me.zakaria.customermicroservice.services;

import me.zakaria.customermicroservice.dto.CustomerRequestDTO;
import me.zakaria.customermicroservice.dto.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO saveCustomer(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO getCustomer(String id);
    CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);
    List<CustomerResponseDTO> listCustomers();
}
