package com.otavioyukio.product_api.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.otavioyukio.product_api.mapper.ProductMapper;
import com.otavioyukio.product_api.model.Product;
import com.otavioyukio.product_api.model.ProductResponseDTO;
import com.otavioyukio.product_api.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
    
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

}
