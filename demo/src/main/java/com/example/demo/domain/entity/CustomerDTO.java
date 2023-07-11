package com.example.demo.domain.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CustomerDTO {
    private Long id;
    private String name;
    private Address address;
    private Date dateOfBirth;
    private String email;
    private List<ProductDTO> products;
}
