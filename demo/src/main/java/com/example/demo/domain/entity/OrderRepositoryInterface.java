package com.example.demo.domain.entity;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepositoryInterface extends CrudRepository<Order, Long> {
}
