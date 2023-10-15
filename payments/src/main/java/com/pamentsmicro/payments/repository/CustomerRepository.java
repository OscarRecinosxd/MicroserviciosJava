package com.pamentsmicro.payments.repository;

import com.pamentsmicro.payments.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
