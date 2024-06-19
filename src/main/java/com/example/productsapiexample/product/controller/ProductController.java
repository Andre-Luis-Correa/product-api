package com.example.productsapiexample.product.controller;

import com.example.productsapiexample.product.domain.dto.CreateProductFormDTO;
import com.example.productsapiexample.product.domain.dto.UpdateProductFormDTO;
import com.example.productsapiexample.product.domain.entitie.Product;
import com.example.productsapiexample.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<CreateProductFormDTO> create(@RequestBody @Valid CreateProductFormDTO createProductFormDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.create(createProductFormDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateProductFormDTO> getProductById(@PathVariable Long id){
        Product product = productService.findProductById(id);
        CreateProductFormDTO createProductFormDTO = productService.convertToProductFormDTO(product);
        return ResponseEntity.ok(createProductFormDTO);
    }

    @GetMapping
    ResponseEntity<List<CreateProductFormDTO>> getAllProducts(){
        return ResponseEntity.ok(productService.findAll());
    }

    @PutMapping("/{id}")
    ResponseEntity<CreateProductFormDTO> update(@PathVariable Long id, @RequestBody UpdateProductFormDTO updateProductFormDTO){
        Product product = productService.findProductById(id);
        productService.update(product, updateProductFormDTO);
        CreateProductFormDTO createProductFormDTO = productService.convertToProductFormDTO(product);
        return ResponseEntity.ok(createProductFormDTO);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> delete(@PathVariable Long id){
        productService.delete(id);
        return ResponseEntity.ok("Produto com id " + id + " removido com sucesso!");
    }

}
