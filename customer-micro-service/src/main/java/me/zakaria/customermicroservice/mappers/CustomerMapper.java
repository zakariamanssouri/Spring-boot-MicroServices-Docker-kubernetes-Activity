package me.zakaria.customermicroservice.mappers;

import me.zakaria.customermicroservice.dto.CustomerRequestDTO;
import me.zakaria.customermicroservice.dto.CustomerResponseDTO;
import me.zakaria.customermicroservice.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
    Customer customerRequestDTOToCustomer(CustomerRequestDTO customerRequestDTO);
}
