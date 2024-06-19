package com.example.productsapiexample.store.mapper;

import com.example.productsapiexample.product.domain.entitie.Product;
import com.example.productsapiexample.store.domain.dto.CreateStoreFormDTO;
import com.example.productsapiexample.store.domain.entity.Store;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CreateStoreFormDTOToStoreMapper {

    @Mapping(source = "storeProductsList", target = "products")
    Store convert(CreateStoreFormDTO createStoreFormDTO, List<Product> storeProductsList);
}
