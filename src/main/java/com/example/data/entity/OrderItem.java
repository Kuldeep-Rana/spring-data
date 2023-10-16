package com.example.data.entity;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "order_iem",schema = "app")
@Data
@Builder
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;

    private int quantity;
}
