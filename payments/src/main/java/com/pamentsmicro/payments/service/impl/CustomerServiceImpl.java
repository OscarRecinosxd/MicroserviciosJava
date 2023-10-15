package com.pamentsmicro.payments.service.impl;

import com.pamentsmicro.payments.entity.Customer;
import com.pamentsmicro.payments.repository.CustomerRepository;
import com.pamentsmicro.payments.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer update(Long id, Customer customer) {
        Customer updatedCostumer = customerRepository.findById(id).orElse(null);
        assert updatedCostumer != null;
        updatedCostumer.setName(customer.getName());
        updatedCostumer.setPhone(customer.getPhone());
        customerRepository.save(updatedCostumer);
        return updatedCostumer;
    }

    @Override
    public Customer create(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public Customer delete(Long id) {
        Customer aux = customerRepository.findById(id).orElse(null);
        customerRepository.deleteById(id);
        return aux;
    }
}
