package com.example.productsapiexample.store.repository;

import com.example.productsapiexample.store.domain.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
