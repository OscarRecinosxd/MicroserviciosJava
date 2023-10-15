package com.pamentsmicro.payments.controller;

import com.pamentsmicro.payments.entity.Customer;
import com.pamentsmicro.payments.service.CustomerService;
import com.pamentsmicro.payments.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping()
    public List<Customer> findAll(){
        return customerService.getAll();
    }
    @GetMapping("/{id}")
    public Customer findById(@PathVariable Long id){
        return customerService.getById(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable String id){
        return null;
    }
    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer){
        Customer save = customerService.create(customer);
        return ResponseEntity.ok(save);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable String id){
        return null;
    }


}
