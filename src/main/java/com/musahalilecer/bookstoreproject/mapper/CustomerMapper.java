package com.musahalilecer.bookstoreproject.mapper;

import com.musahalilecer.bookstoreproject.dto.CustomerDto;
import com.musahalilecer.bookstoreproject.model.Customer;

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
