package com.example.data.service;

import com.example.data.entity.Product;
import com.example.data.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> fetchProductByName(String name){
        return productRepository.findByNameContaining(name);
    }
}
