package com.example.demo.application;

import com.example.demo.domain.entity.CustomerDoesntExistException;
import com.example.demo.domain.entity.CustomerRepositoryInterface;
import com.example.demo.domain.entity.Product;
import com.example.demo.domain.entity.ProductRepositoryInterface;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class ProductService implements ProductInterface{

    private final ProductRepositoryInterface productRepositoryInterface;

    private final CustomerRepositoryInterface customerRepositoryInterface;

    @Override
    public Product getProductById(Long id) throws Exception{
        //productRepositoryInterface.findById(id).orElseThrow(()-> new Exception("no product found"));
        if(productRepositoryInterface.existsById(id)){
            return productRepositoryInterface.findById(id).get();
        }
        throw new Exception("no id found");
    }

    @Override
    public List<Product> getProductsByCustomerId(Long id) throws Exception {
        if(customerRepositoryInterface.existsById(id)){
            return customerRepositoryInterface.findById(id).get().getProducts();
        }
        throw new CustomerDoesntExistException("no id found");
    }

}
