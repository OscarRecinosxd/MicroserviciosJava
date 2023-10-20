/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paymentchain.customer.controller;

import com.paymentchain.customer.CustomerService;
import com.paymentchain.customer.entities.Customer;
import com.paymentchain.customer.respository.CustomerRepository;
import io.netty.channel.ChannelOption;
import io.netty.channel.epoll.EpollChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

/**
 *
 * @author sotobotero
 */
@RestController
@RequestMapping("/customer")
public class CustomerRestController {
    
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;

    @GetMapping()
    public List<Customer> list() {

        List<Customer> customers = customerRepository.findAll();

        customers.forEach(c ->
                c.getProducto().forEach(p ->
                        p.setProductName(customerService.getProductName(p.getProductId()))
                        ));

        return customers;
    }
    
    @GetMapping("/{id}")
    public Customer get(@PathVariable Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @GetMapping("/full")
    public Customer getByCode(@RequestParam String code) {
        Customer customer = customerRepository.findByCode(code);
        customer.getProducto().forEach(p ->
                    p.setProductName(customerService.getProductName(p.getProductId()))
                );
        return customer;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable Long id, @RequestBody Customer input) {
        input.setId(id);
        Customer save = customerRepository.save(input);
        return ResponseEntity.ok(save);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Customer input) {
        input.getProducto().forEach(x -> x.setCustomer(input));
        Customer save = customerRepository.save(input);
        return ResponseEntity.ok(save);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Customer> findById = customerRepository.findById(id);
        findById.ifPresent(customerRepository::delete);
        return ResponseEntity.ok().build();
    }




    
}
