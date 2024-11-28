package com.musahalilecer.book_store_project.mapper;

import com.musahalilecer.book_store_project.dto.CustomerDto;
import com.musahalilecer.book_store_project.model.Customer;

public class CustomerMapper {
    public static CustomerDto toCustomerDto(Customer customer) {
        return new CustomerDto(
                customer.getId(),
                customer.getUsername(),
                customer.getPassword(),
                customer.getImage()
        );
    }
    public static Customer toEntity(CustomerDto customerDto) {
        return new Customer(
                customerDto.getId(),
                customerDto.getUsername(),
                customerDto.getPassword(),
                customerDto.getImage()
        );
    }
}
