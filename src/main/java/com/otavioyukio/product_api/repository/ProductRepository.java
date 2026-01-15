package com.otavioyukio.product_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.otavioyukio.product_api.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
