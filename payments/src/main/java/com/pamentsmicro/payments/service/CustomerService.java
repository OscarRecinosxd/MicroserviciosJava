package com.pamentsmicro.payments.service;

import com.pamentsmicro.payments.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    List<Customer> getAll();

    Customer getById(Long id);

    Customer update(Long id, Customer customer);

    Customer create(Customer customer);

    Customer delete(Long id);
}
