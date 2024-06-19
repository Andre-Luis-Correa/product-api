package com.example.productsapiexample.store.controller;

import com.example.productsapiexample.store.domain.dto.CreateStoreFormDTO;
import com.example.productsapiexample.store.domain.entity.Store;
import com.example.productsapiexample.store.service.StoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @PostMapping
    ResponseEntity<Store> create(@RequestBody @Valid CreateStoreFormDTO createStoreFormDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(storeService.create(createStoreFormDTO));
    }

    @GetMapping("/{id}")
    ResponseEntity<Store> getStoreById(@PathVariable Long id){
        Store store = storeService.findStoreById(id);
        return ResponseEntity.ok(store);
    }

}
