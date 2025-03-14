package com.musahalilecer.bookstoreproject.total.controller;

import com.musahalilecer.bookstoreproject.total.dto.CustomerDto;
import com.musahalilecer.bookstoreproject.total.service.BookService;
import com.musahalilecer.bookstoreproject.total.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers/")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private BookService bookService;

    public CustomerController() {
        this.customerService = new CustomerService();
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable long id) {
        try {
            CustomerDto customerDto = customerService.getCustomerById(id);
            return ResponseEntity.ok(customerDto);
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        try{
            CustomerDto createdCustomer = customerService.createCustomer(customerDto);
            return ResponseEntity.ok(createdCustomer);
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable long id, @RequestBody CustomerDto customerDto) {
        try{
            CustomerDto updatedCustomer = customerService.updateCustomer(id, customerDto);
            return ResponseEntity.ok(updatedCustomer);
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    /*
    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerDto> deleteCustomer(@PathVariable long id) {
        try{
            bookService.deleteBook(id);
            return ResponseEntity.noContent().build();
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

     */
}
