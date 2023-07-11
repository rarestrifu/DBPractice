package com.example.demo.domain.entity;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepositoryInterface extends CrudRepository<Product, Long> {
    List<Product> findByCustomerId(Long Id);
}
