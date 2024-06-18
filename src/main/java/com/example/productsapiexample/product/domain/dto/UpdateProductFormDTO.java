package com.example.productsapiexample.product.domain.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record UpdateProductFormDTO(
        @NotNull
        Double price,

        @NotNull
        @Min(1)
        Integer quantity

) { }
