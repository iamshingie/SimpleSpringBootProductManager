package com.example.ProductManagementSystem.serviceImpl;

import com.example.ProductManagementSystem.domain.Product;
import com.example.ProductManagementSystem.productRepo.ProductRepo;
import com.example.ProductManagementSystem.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> listAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepo.findById(id).get();
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepo.deleteById(id);

    }


}
