package com.example.data.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "products",schema = "app")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double price;

}
