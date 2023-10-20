package com.oscarrecinos.product.service;

import com.oscarrecinos.product.entity.Product;
import com.oscarrecinos.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product,Long id) {
        product.setId(id);
        return productRepository.save(product);
    }

    @Override
    public Product delete(Long id) {
        Optional<Product> findById = productRepository.findById(id);
        findById.ifPresent(productRepository::delete);
        return null;
    }
}
