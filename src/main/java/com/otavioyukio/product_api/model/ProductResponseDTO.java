package com.otavioyukio.product_api.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductResponseDTO(
    Long id,
    String title,
    String description,
    BigDecimal price,
    LocalDateTime created_at,
    LocalDateTime updated_at
) {
    
}
