package com.example.data.service;

import com.example.data.entity.Customer;
import com.example.data.entity.Order;
import com.example.data.entity.OrderItem;
import com.example.data.repository.CustomerRepository;
import com.example.data.repository.OrderRepository;
import com.example.data.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    public void createOrder(){

        var customers  = customerRepository.findAll();
        int [] limit = {5};
        customers.forEach(customer -> {
            var products = productRepository.findAll().stream().limit(limit[0]).toList();
            var order = new Order();
            var orderItems  = new ArrayList<OrderItem>();
            products.forEach(product -> {
                orderItems.add(OrderItem.builder().order(order).product(product).quantity(10).build());
            });
            order.setOrderDate(new Date());
            order.setCustomer(customer);
            order.setOrderItems(orderItems);
            limit[0] += 5;
            orderRepository.save(order);
            log.info("order created with id {}",order.getId());
        });
    }

}
