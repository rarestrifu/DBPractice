package com.example.demo.application;

import com.example.demo.domain.entity.*;
import com.example.demo.utils.JsonNullableUtils;
import lombok.AllArgsConstructor;
import org.openapitools.jackson.nullable.JsonNullable;
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

    @Override
    public Product updateProductById(Long id, ProductUpdateDTO productUpdateDTO) throws Exception {
        if(productRepositoryInterface.existsById(id)){
            Product product = productRepositoryInterface.findById(id).get();
            JsonNullableUtils.changeIfPresent(productUpdateDTO.getName(), product::setName);
            JsonNullableUtils.changeIfPresent(productUpdateDTO.getPrice(), product::setPrice);

            productRepositoryInterface.save(product);
        }
        throw new Exception("patch not working");
    }

    public ProductDTO deleteProductById(Long productID) throws Exception{
        if(productRepositoryInterface.existsById(productID)){
            productRepositoryInterface.deleteById(productID);
        }
        else{
            throw new Exception("Customer doesn't exist");
        }
        return null;
    }

}
