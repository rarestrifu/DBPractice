package com.example.demo.application;

import com.example.demo.domain.entity.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements CustomerInterface{

    private final CustomerRepositoryInterface customerRepositoryInterface;

    private final AddressRepositoryInterface addressRepositoryInterface;

    private final ProductRepositoryInterface productRepositoryInterface;

    public CustomerService(CustomerRepositoryInterface customerRepositoryInterface, AddressRepositoryInterface addressRepositoryInterface, ProductRepositoryInterface productRepositoryInterface) {
        this.customerRepositoryInterface = customerRepositoryInterface;
        this.addressRepositoryInterface = addressRepositoryInterface;
        this.productRepositoryInterface = productRepositoryInterface;
    }

    @Override
    public Customer createCustomer(Customer customer) throws CustomerExistsException {
        customerRepositoryInterface.save(customer);
        for (Product product: customer.getProducts()) {
            product.setCustomer(customer);
            productRepositoryInterface.save(product);
        }
        addressRepositoryInterface.save(customer.getAddress());
        productRepositoryInterface.saveAll(customer.getProducts());
        return customerRepositoryInterface.save(customer);
    }

    @Override
    public Customer getCustomer(Long id) throws CustomerDoesntExistException {
        if(customerRepositoryInterface.existsById(id)){
            return customerRepositoryInterface.findById(id).get();
        }
        throw new CustomerDoesntExistException("Customer doesn't exist");
    }

    @Override
    public Customer updateCustomer(Customer customer) throws CustomerExistsException {
        if(customerRepositoryInterface.existsById(customer.getId())){
            addressRepositoryInterface.save(customer.getAddress());
            return customerRepositoryInterface.save(customer);
        }
        throw new CustomerExistsException("Customer already exists");
    }

    public void deleteCustomer(Long id) throws CustomerDoesntExistException {
        if(customerRepositoryInterface.existsById(id)){
            addressRepositoryInterface.delete(customerRepositoryInterface.findById(id).get().getAddress());
            customerRepositoryInterface.delete(customerRepositoryInterface.findById(id).get());
        }
        throw new CustomerDoesntExistException("Customer doesn't exist");
    }

    @Override
    public List<Customer> getAllCustomers() throws CustomerDoesntExistException {
        if(customerRepositoryInterface.findAll().size()>0){
            return customerRepositoryInterface.findAll();
        }
        throw new CustomerDoesntExistException("No customer found");
    }

    @Override
    public Customer addProductsToCustomer(Long id, Product product) throws Exception {
        if(customerRepositoryInterface.existsById(id)){
            customerRepositoryInterface.findById(id).get().getProducts().add(product);
            product.setCustomer(customerRepositoryInterface.findById(id).get());
            productRepositoryInterface.save(product);
            return customerRepositoryInterface.findById(id).get();
        }
        throw new CustomerDoesntExistException("no id found");
    }
}
