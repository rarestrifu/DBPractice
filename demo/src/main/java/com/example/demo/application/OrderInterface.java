package com.example.demo.application;

import com.example.demo.domain.entity.Order;
import com.example.demo.domain.entity.Product;

import java.util.List;

public interface OrderInterface {
    public Order createOrder(Long id, List<Product> productList,String payment_type);
}
