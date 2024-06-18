package com.example.productsapiexample.product.repository;

import com.example.productsapiexample.product.domain.entitie.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
