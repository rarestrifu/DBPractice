package com.example.demo.application;

import com.example.demo.domain.entity.Product;
import com.example.demo.domain.entity.ProductUpdateDTO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductInterface {
    public Product getProductById(Long id) throws Exception;

    public List<Product> getProductsByCustomerId(Long id) throws Exception;

    public Product updateProductById(Long id, ProductUpdateDTO productUpdateDTO) throws Exception;
}
