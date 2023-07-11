package com.example.demo.adapter.rest;

import com.example.demo.application.CustomerService;
import com.example.demo.application.ProductService;
import com.example.demo.domain.entity.*;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ModelMapper modelMapper;

    private final ProductService productService;

    @GetMapping("/getProduct/{id}")
    public ProductDTO getProductsById(@PathVariable(value = "id") Long id) throws Exception {
        return modelMapper.map(productService.getProductById(id), ProductDTO.class);
    }

    @GetMapping("/getAllProducts/{customerID}")
    public List<ProductDTO> getProductsByCustomerId(@PathVariable(value = "customer_id") Long id) throws Exception {
        return
    }

    @DeleteMapping("/deleteProduct/{productID}/customerID/{customerID}")
    public void deleteProductByCustomerId(@PathVariable(value = "productID") Long productID,
                                          @PathVariable(value = "productID") Long customerID){
        return;
    }

}
