package com.otavioyukio.product_api.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.otavioyukio.product_api.exception.ProductNotFoundException;
import com.otavioyukio.product_api.mapper.ProductMapper;
import com.otavioyukio.product_api.model.Product;
import com.otavioyukio.product_api.model.ProductRequestDTO;
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

    public List<ProductResponseDTO> getAllProducts() {
        // Ordena por titulo e preço de modo ascendente 
        Sort sort = Sort.by("title").ascending()
                .and(Sort.by("price").ascending());

        return productRepository.findAll(sort).stream().map(productMapper::toResponse).toList();
    }
    
    public ProductResponseDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                            .orElseThrow(() -> new ProductNotFoundException(id));
        
        return productMapper.toResponse(product);
    }

    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        Product product = productMapper.toEntity(productRequestDTO);
        return productMapper.toResponse(productRepository.save(product));
    }

    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequestDTO) {
        Product product = productRepository.findById(id)
                            .orElseThrow(() -> new ProductNotFoundException(id));
        
        product.setTitle(productRequestDTO.title());
        if (productRequestDTO.description() != null) product.setDescription(productRequestDTO.description());
        product.setPrice(productRequestDTO.price());
        
        Product updatedProduct = productRepository.save(product);

        return productMapper.toResponse(updatedProduct);
    }


    public void deleteProductById(Long id) { 
        Product product = productRepository.findById(id)
                            .orElseThrow(() -> new ProductNotFoundException(id));

        productRepository.delete(product);
    }
}
