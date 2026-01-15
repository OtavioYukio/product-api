package com.otavioyukio.product_api.mapper;

import org.springframework.stereotype.Component;

import com.otavioyukio.product_api.model.Product;
import com.otavioyukio.product_api.model.ProductRequestDTO;
import com.otavioyukio.product_api.model.ProductResponseDTO;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequestDTO dto) {
        return new Product(
            dto.title(),
            dto.description(),
            dto.price()
        );
    }

    public ProductResponseDTO toResponse(Product entity) {
        return new ProductResponseDTO(
            entity.getId(),
            entity.getTitle(),
            entity.getDescription(),
            entity.getPrice(),
            entity.getCreatedAt(),
            entity.getUpdatedAt()
        );
    }

}
