package com.example.demo.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<Product> productList;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "payment_received")
    private boolean paymentReceived;

    @Column(name = "status")
    private String status;

}
