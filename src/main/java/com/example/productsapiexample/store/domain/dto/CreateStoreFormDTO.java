package com.example.productsapiexample.store.domain.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record CreateStoreFormDTO(
        @NotBlank
        String name,

        @NotBlank
        String owner,

        List<Long> productsIdList
) { }
