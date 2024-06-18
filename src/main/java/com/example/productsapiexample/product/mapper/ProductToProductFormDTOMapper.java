package com.example.productsapiexample.product.mapper;

import com.example.productsapiexample.product.domain.dto.CreateProductFormDTO;
import com.example.productsapiexample.product.domain.entitie.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductToProductFormDTOMapper {

    CreateProductFormDTO convert(Product product);
}
