package com.oscarrecinos.product.service;

import com.oscarrecinos.product.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    Product getById(Long id);

    Product create(Product product);

    Product update(Product product);

    Product delete(Long id);
}
