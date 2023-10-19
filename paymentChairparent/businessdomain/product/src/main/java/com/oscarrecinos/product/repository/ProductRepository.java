package com.oscarrecinos.product.repository;

import com.oscarrecinos.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
