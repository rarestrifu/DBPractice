package com.example.demo.application;

import com.example.demo.domain.entity.Order;
import com.example.demo.domain.entity.OrderRepositoryInterface;
import com.example.demo.domain.entity.Product;
import com.example.demo.domain.entity.ProductRepositoryInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements OrderInterface{

    private final OrderRepositoryInterface orderRepositoryInterface;

    private final ProductRepositoryInterface productRepositoryInterface;

    public OrderService(OrderRepositoryInterface orderRepositoryInterface, ProductRepositoryInterface productRepositoryInterface) {
        this.orderRepositoryInterface = orderRepositoryInterface;
        this.productRepositoryInterface = productRepositoryInterface;
    }

    @Override
    public Order createOrder(Long id, List<Product> productList, String payment_type) {
        Order order = new Order();
        order.setPaymentReceived(false);
        order.setPaymentType(payment_type);
        order.setStatus("Not finalized");
        order.setProductList(productList);
        orderRepositoryInterface.save(order);
        for (Product product: orderRepositoryInterface.findById(order.getId()).get().getProductList()) {

        }
        return order;
    }
}
