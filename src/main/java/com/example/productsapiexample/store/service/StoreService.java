package com.example.productsapiexample.store.service;

import com.example.productsapiexample.exception.type.EntityWasNotFoundException;
import com.example.productsapiexample.product.domain.entitie.Product;
import com.example.productsapiexample.product.service.ProductService;
import com.example.productsapiexample.store.domain.dto.CreateStoreFormDTO;
import com.example.productsapiexample.store.domain.entity.Store;
import com.example.productsapiexample.store.mapper.CreateStoreFormDTOToStoreMapper;
import com.example.productsapiexample.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;
    private final CreateStoreFormDTOToStoreMapper createStoreFormDTOToStoreMapper;

    private final ProductService productService;

    public Store create(CreateStoreFormDTO createStoreFormDTO) {
        List<Product> storeProductsList = getStoreProductsById(createStoreFormDTO.productsIdList());
        Store store = createStoreFormDTOToStoreMapper.convert(createStoreFormDTO, storeProductsList);
        storeRepository.save(store);
        return store;
    }

    private List<Product> getStoreProductsById(List<Long> productsIdList) {
        List<Product> productList = new ArrayList<>();

        for(Long id : productsIdList){
            Product product = productService.findProductById(id);
            productList.add(product);
        }

        return productList;
    }

    public Store findStoreById(Long id) {
        return storeRepository.findById(id).orElseThrow(() -> new EntityWasNotFoundException("store", id));
    }
}
