package com.example.demo.adapter.rest;

import com.example.demo.application.CustomerService;
import com.example.demo.domain.entity.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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

    @PatchMapping("/updateCustomer/{id}")
    public CustomerDTO updateCustomer(@PathVariable(value = "id") Long id,
                                      @RequestBody CustomerUpdateDTO customerUpdateDTO) throws Exception{
        return modelMapper.map(customerService.updateCustomer(id, customerUpdateDTO), CustomerDTO.class);
    }

    @GetMapping("/getAllCustomers")
    public List<CustomerDTO> getAllCustomers() throws Exception{
        return Arrays.asList(modelMapper.map(customerService.getAllCustomers(),
                CustomerDTO[].class));
    }

    @PutMapping("/addProducts/{customerID}")
    public CustomerDTO addProductsToCustomer(@PathVariable(value = "customerID") Long id, @RequestBody Product product) throws Exception {
        return modelMapper.map(customerService.addProductsToCustomer(id, product), CustomerDTO.class);
    }


}
