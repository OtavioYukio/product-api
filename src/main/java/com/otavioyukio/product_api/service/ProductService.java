package com.otavioyukio.product_api.service;

import java.util.List;

import com.otavioyukio.product_api.model.ProductRequestDTO;
import com.otavioyukio.product_api.model.ProductResponseDTO;

public interface ProductService {
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO getProductById(Long id);
    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);
    ProductRequestDTO updateProduct(Long id, ProductRequestDTO productRequestDTO);
    void deleteProductById(Long id);
}
