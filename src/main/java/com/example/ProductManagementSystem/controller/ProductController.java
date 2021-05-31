package com.example.ProductManagementSystem.controller;

import com.example.ProductManagementSystem.domain.Product;
import com.example.ProductManagementSystem.serviceImpl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class ProductController {

    private final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String listAllProducts(Model model){
        List<Product> products = productService.listAllProducts();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/new")
    public String createProduct(Model model){
        Product newProduct = new Product();
        model.addAttribute("product",newProduct);
        return "newProductForm";
    }

    @PostMapping("/product")
    public String saveProduct(@ModelAttribute("product") Product product){
        productService.saveProduct(product);
        return "redirect:/";
    }

    @GetMapping("product/edit/{id}")
    public String editProductForm(@PathVariable Long id, Model model){
    model.addAttribute("product", productService.getProductById(id));
    return "editProductForm";
    }
    @PostMapping("/product/{id}")
    public  String updateProduct(@PathVariable Long id,
                                 @ModelAttribute("product") Product product,
                                 Model model){

//        Get products from the database by ID
        Product existingProduct = productService.getProductById(id);
        existingProduct.setId(id);
        existingProduct.setName(product.getName());
        existingProduct.setBrand(product.getBrand());
        existingProduct.setMadeIn(product.getMadeIn());
        existingProduct.setPrice(product.getPrice());

//        Save updated student object
        productService.updateProduct(existingProduct);
        return "redirect:/";
    }
    @GetMapping("/product/{id}")
    public  String deleteProduct(@PathVariable Long id){
        productService.deleteProductById(id);
        return "redirect:/";
    }
}

