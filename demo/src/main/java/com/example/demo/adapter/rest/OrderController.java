package com.example.demo.adapter.rest;

import com.example.demo.application.OrderService;
import com.example.demo.domain.entity.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/createOrder")
    public Order createOrderById(@RequestBody Order order){
        return orderService.createOrder(order.getId(), order.getProductList(), order.getPaymentType());
    }
}
