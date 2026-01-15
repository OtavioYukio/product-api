package com.otavioyukio.product_api.mapper;

import com.otavioyukio.product_api.model.Product;
import com.otavioyukio.product_api.model.ProductRequestDTO;

public class ProductMapper {

    public Product toEntity(ProductRequestDTO dto) {
        return new Product(
            dto.title(),
            dto.description(),
            dto.price()
        );
    }

}
