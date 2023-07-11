package com.example.demo.application;

import com.example.demo.domain.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductInterface {
    public Product getProductById(Long id) throws Exception;

    public List<Product> getProductsByCustomerId(Long id) throws Exception;
}
