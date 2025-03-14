package com.musahalilecer.bookstoreproject.total.mapper;

import com.musahalilecer.bookstoreproject.total.dto.CustomerDto;
import com.musahalilecer.bookstoreproject.total.model.Customer;

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
