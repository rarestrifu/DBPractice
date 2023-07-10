package com.example.demo.adapter.rest;

import com.example.demo.application.CustomerService;
import com.example.demo.domain.entity.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/createCustomer")
    public Customer createCustomer(@RequestBody Customer customer) throws Exception {
        return customerService.createCustomer(customer);
    }

    @DeleteMapping("/deleteCustomer")
    public void deleteCustomer(@RequestParam Long id) throws Exception{
        customerService.deleteCustomer(id);
    }

    @GetMapping("/getCustomer")
    public Customer getCustomer(@RequestParam Long id) throws Exception{
        return customerService.getCustomer(id);
    }

    @PutMapping("/updateCustomer")
    public Customer updateCustomer(@RequestBody Customer customer) throws Exception{
        return customerService.updateCustomer(customer);
    }

    @GetMapping("/getAllCustomers")
    public List<Customer> getAllCustomers() throws Exception{
        return customerService.getAllCustomers();
    }
}
