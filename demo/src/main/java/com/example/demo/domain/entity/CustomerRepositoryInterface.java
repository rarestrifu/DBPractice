package com.example.demo.domain.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepositoryInterface extends CrudRepository<Customer, Long> {
    Customer save(Customer customer);
    Optional<Customer> findById(Long id);

    List<Customer> findAll();
}
