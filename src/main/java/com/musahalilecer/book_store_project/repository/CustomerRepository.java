package com.musahalilecer.book_store_project.repository;

import com.musahalilecer.book_store_project.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //  Customer findByCustomerName(String customerName);
}
