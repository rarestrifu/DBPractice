package com.example.demo.application;

import com.example.demo.domain.entity.Customer;

import java.util.List;

public interface CustomerInterface {
    public Customer createCustomer(Customer customer) throws Exception;
    public Customer getCustomer(Long id) throws Exception;
    public Customer updateCustomer(Customer customer) throws Exception;
    public List<Customer> getAllCustomers() throws Exception;
}
