package com.otavioyukio.product_api.model;

import java.math.BigDecimal;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record ProductRequestDTO(
    @NotNull
    @Size(max = 255)
    String title,

    String description,
    
    @NotNull
    @Digits(integer = 10, fraction = 2)
    @PositiveOrZero
    BigDecimal price
) {
    
}
