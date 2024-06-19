package com.example.productsapiexample.product.service;

import com.example.productsapiexample.exception.type.EntityWasNotFoundException;
import com.example.productsapiexample.product.domain.dto.CreateProductFormDTO;
import com.example.productsapiexample.product.domain.dto.UpdateProductFormDTO;
import com.example.productsapiexample.product.domain.entitie.Product;
import com.example.productsapiexample.product.mapper.ProductToProductFormDTOMapper;
import com.example.productsapiexample.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductToProductFormDTOMapper productToProductFormDTOMapper;

    public CreateProductFormDTO create(CreateProductFormDTO createProductFormDTO) {
        Product product = new Product();
        product.setName(createProductFormDTO.name());
        product.setPrice(createProductFormDTO.price());
        product.setQuantity(createProductFormDTO.quantity());
        product.setCategory(createProductFormDTO.category());

        productRepository.save(product);
        return createProductFormDTO;
    }

    public Product findProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new EntityWasNotFoundException("product", id));
    }

    public List<CreateProductFormDTO> findAll() {
        List<Product> productList = productRepository.findAll();
        return convertToProductFormDTOList(productList);
    }

    private List<CreateProductFormDTO> convertToProductFormDTOList(List<Product> productList) {
        return productList.stream().map(this::convertToProductFormDTO).toList();
    }

    public CreateProductFormDTO convertToProductFormDTO(Product product) {
        return productToProductFormDTOMapper.convert(product);
    }

    public void update(Product product, UpdateProductFormDTO updateProductFormDTO) {
        product.setPrice(updateProductFormDTO.price());
        product.setQuantity(updateProductFormDTO.quantity());
        productRepository.save(product);
    }

    public void delete(Long id) {
        Product product = findProductById(id);
        productRepository.delete(product);
    }
}
