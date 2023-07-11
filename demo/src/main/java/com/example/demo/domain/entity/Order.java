package com.example.demo.domain.entity;

import javax.persistence.*;

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private Long product_id;

    private String payment_type;
    private boolean payment_received;

}
