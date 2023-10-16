package com.example.data.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "customer_address",schema = "app")
@Data
public class CustomerAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;
    private String zipCode;
    private String country;

    @OneToOne(mappedBy = "address")
    private Customer customer;
}
