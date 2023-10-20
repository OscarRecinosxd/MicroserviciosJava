package com.oscarrecinos.product.controller;

import com.oscarrecinos.product.entity.Product;
import com.oscarrecinos.product.repository.ProductRepository;
import com.oscarrecinos.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    //@Value("${user.role}")
    private String role;

    @GetMapping()
    public List<Product> findAll() {
        System.out.println(role);
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable Long id,@RequestBody Product product) {
        Product save = productService.update(product,id);
        return ResponseEntity.ok(save);
    }

    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody Product product) {
        Product save = productService.create(product);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.ok().build();
    }
}
