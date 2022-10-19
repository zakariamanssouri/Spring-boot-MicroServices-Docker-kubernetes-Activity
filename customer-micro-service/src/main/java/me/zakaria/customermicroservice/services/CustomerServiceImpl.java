package me.zakaria.customermicroservice.services;

import me.zakaria.customermicroservice.dto.CustomerRequestDTO;
import me.zakaria.customermicroservice.dto.CustomerResponseDTO;
import me.zakaria.customermicroservice.entities.Customer;
import me.zakaria.customermicroservice.mappers.CustomerMapper;
import me.zakaria.customermicroservice.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponseDTO saveCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer customer= customerMapper.customerRequestDTOToCustomer(customerRequestDTO);
        Customer savedCustomer= customerRepository.save(customer);
        return customerMapper.customerToCustomerResponseDTO(savedCustomer);
    }

    @Override
    public CustomerResponseDTO getCustomer(String id) {
        Customer customer = customerRepository.findById(id).get();
        return customerMapper.customerToCustomerResponseDTO(customer);
    }

    @Override
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
        Customer customer = customerMapper.customerRequestDTOToCustomer(customerRequestDTO);
        Customer updatedCustomer = customerRepository.save(customer);
        return customerMapper.customerToCustomerResponseDTO(updatedCustomer);
    }

    @Override
    public List<CustomerResponseDTO> listCustomers() {
        List<Customer> customers=customerRepository.findAll();
        return customers.stream().map(customer -> customerMapper.customerToCustomerResponseDTO(customer)).toList();
    }
}
