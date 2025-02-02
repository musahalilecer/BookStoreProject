package com.musahalilecer.book_store_project.service;

import com.musahalilecer.book_store_project.dto.CustomerDto;
import com.musahalilecer.book_store_project.mapper.CustomerMapper;
import com.musahalilecer.book_store_project.model.Customer;
import com.musahalilecer.book_store_project.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    // Get all customers as DTOs
    public List<CustomerDto> getCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(CustomerMapper::toCustomerDto)
                .collect(Collectors.toList());
    }

    // Get a single customer by ID as a DTO
    public CustomerDto getCustomerById(long id) {
        return customerRepository.findById(id)
                .map(CustomerMapper::toCustomerDto)
                .orElse(null);
    }

    // Save a new customer from DTO
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.toEntity(customerDto);
        Customer savedCustomer = customerRepository.save(customer);
        return CustomerMapper.toCustomerDto(savedCustomer);
    }

    // Update an existing customer
    public CustomerDto updateCustomer(long id, CustomerDto customerDto) {
        return customerRepository.findById(id).map(existingCustomer -> {
            existingCustomer.setUsername(customerDto.getUsername());
            existingCustomer.setPassword(customerDto.getPassword());
            existingCustomer.setImage(customerDto.getImage());
            Customer updatedCustomer = customerRepository.save(existingCustomer);
            return CustomerMapper.toCustomerDto(updatedCustomer);
        }).orElse(null);
    }

    // Delete a customer by ID
    public void deleteCustomer(long id) {
        customerRepository.deleteById(id);
    }
}
