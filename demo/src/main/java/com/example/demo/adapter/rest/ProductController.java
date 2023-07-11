package com.example.demo.adapter.rest;

import com.example.demo.application.CustomerService;
import com.example.demo.application.ProductService;
import com.example.demo.domain.entity.*;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ModelMapper modelMapper;

    private final ProductService productService;

    @GetMapping("/getProduct/{id}") //WORKING
    public ProductDTO getProductsById(@PathVariable(value = "id") Long id) throws Exception {
        return modelMapper.map(productService.getProductById(id), ProductDTO.class);
    }

    @GetMapping("/getAllProducts/{customerID}") //WORKING
    public List<ProductDTO> getProductsByCustomerId(@PathVariable(value = "customerID") Long id) throws Exception {
        return Arrays.asList(modelMapper.map(productService.getProductsByCustomerId(id),
                ProductDTO[].class));
    }

    @DeleteMapping("/deleteProduct/{productID}")
    public void deleteProductByCustomerId(@PathVariable(value = "productID") Long productID)
                                          throws Exception{
        modelMapper.map(productService.deleteProductById(productID),ProductDTO.class);
    }

    @PatchMapping("/updateProduct/{id}")
    public Product updateProductById(@PathVariable(value = "id") Long id) throws Exception {

    }

}
