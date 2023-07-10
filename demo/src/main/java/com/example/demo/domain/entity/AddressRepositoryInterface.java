package com.example.demo.domain.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepositoryInterface extends CrudRepository<Address, Long> {
}
