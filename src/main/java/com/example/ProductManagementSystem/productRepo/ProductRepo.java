package com.example.ProductManagementSystem.productRepo;

import com.example.ProductManagementSystem.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
