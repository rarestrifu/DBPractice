package com.example.demo.domain.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CustomerDTO {
    private Long id;
    private Address address;
    private Date dateOfBirth;
    private String email;
}
