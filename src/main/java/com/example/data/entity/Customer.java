package com.example.data.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "customer",schema = "app")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    @OneToOne
    private CustomerAddress address;

}

