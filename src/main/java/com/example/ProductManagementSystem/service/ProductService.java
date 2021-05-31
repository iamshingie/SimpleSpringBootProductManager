package com.example.ProductManagementSystem.service;

import com.example.ProductManagementSystem.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> listAllProducts();
    Product createProduct(Product product);
    Product saveProduct(Product product);
    Product getProductById(Long id);
    Product updateProduct(Product product);
    void deleteProductById(Long id);
}
