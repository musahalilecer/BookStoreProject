package com.musahalilecer.book_store_project.repository;

import com.musahalilecer.book_store_project.model.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //  Customer findByCustomerName(String customerName);

    @Modifying
    @Transactional //dşadjasdjasd
    @Query(value="delete from book_customer where customer_id = :id", nativeQuery=true)
    void deleteFromBookCustomerById(@Param("id") Long id);
}
