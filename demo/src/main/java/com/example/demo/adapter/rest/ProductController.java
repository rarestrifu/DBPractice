package com.example.demo.adapter.rest;

import com.example.demo.application.CustomerService;
import com.example.demo.application.ProductService;
import com.example.demo.domain.entity.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final CustomerService customerService;

    private final ProductService productService;

    @GetMapping("/getProduct/{id}")
    public Product getProductsById(@PathVariable(value = "id") Long id) throws Exception {
        return productService.getProductById(id);
    }

    @GetMapping("/getAllProducts/{customerID}")
    public List<Product> getProductsByCustomerId(@PathVariable(value = "customer_id") Long id) throws Exception {
        return productService.getProductsByCustomerId(id);
    }

    @DeleteMapping("/deleteProduct/{productID}/customerID/{customerID}")
    public void deleteProductByCustomerId(@PathVariable(value = "productID"))

}
