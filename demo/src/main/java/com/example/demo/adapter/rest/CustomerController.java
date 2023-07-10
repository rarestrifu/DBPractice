package com.example.demo.adapter.rest;

import com.example.demo.application.CustomerService;
import com.example.demo.domain.entity.Customer;
import com.example.demo.domain.entity.CustomerDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ModelMapper modelMapper;

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/createCustomer")
    public CustomerDTO createCustomer(@RequestBody Customer customer) throws Exception {
        return modelMapper.map(customerService.createCustomer(customer), CustomerDTO.class);
    }

    @DeleteMapping("/deleteCustomer")
    public void deleteCustomer(@RequestParam Long id) throws Exception{
        customerService.deleteCustomer(id);
    }

    @GetMapping("/getCustomer")
    public CustomerDTO getCustomer(@RequestParam Long id) throws Exception{
        return modelMapper.map(customerService.getCustomer(id), CustomerDTO.class);
    }

    @PutMapping("/updateCustomer")
    public CustomerDTO updateCustomer(@RequestBody Customer customer) throws Exception{
        return modelMapper.map(customerService.updateCustomer(customer), CustomerDTO.class);
    }

    @GetMapping("/getAllCustomers")
    public List<Customer> getAllCustomers() throws Exception{
        return customerService.getAllCustomers();
    }
}
