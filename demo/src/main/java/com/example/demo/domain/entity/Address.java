package com.example.demo.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @OneToOne(mappedBy = "address")
    private Customer customer;

    @Column(name = "city")
    private String city;

    @Column(name = "postalCode")
    private Long postalCode;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private int number;

    @Column(name = "country")
    private String country;




}
