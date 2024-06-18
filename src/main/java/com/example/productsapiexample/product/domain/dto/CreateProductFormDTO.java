package com.example.productsapiexample.product.domain.dto;

import com.example.productsapiexample.product.enums.ProductCategory;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateProductFormDTO(

        @NotBlank
        String name,

        @NotNull
        Double price,

        @NotNull
        @Min (1)
        Integer quantity,

        @NotNull
        ProductCategory category
) { }
