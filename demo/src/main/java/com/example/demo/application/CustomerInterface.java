package com.example.demo.application;

import com.example.demo.domain.entity.Customer;
import com.example.demo.domain.entity.CustomerUpdateDTO;
import com.example.demo.domain.entity.Product;

import java.util.List;

public interface CustomerInterface {
    public Customer createCustomer(Customer customer) throws Exception;
    public Customer getCustomer(Long id) throws Exception;
    public Customer updateCustomer(Long id, CustomerUpdateDTO customerUpdateDTO) throws Exception;
    public List<Customer> getAllCustomers() throws Exception;
    public Customer addProductsToCustomer(Long id, Product product) throws Exception;
}
