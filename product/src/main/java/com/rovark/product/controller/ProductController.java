package com.rovark.product.controller;

import com.rovark.product.entity.ProductEntity;
import com.rovark.product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductEntity> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductEntity getProductById(
            @PathVariable Long id){
        return productService.getProductById(id);
    }

    @PostMapping
    public ProductEntity createProduct(
            @Valid @RequestBody ProductEntity productEntity){
        return productService.createProduct(productEntity);
    }

    @PutMapping("/{id}")
    public ProductEntity updateProductById(
            @PathVariable Long id,
            @Valid @RequestBody ProductEntity productEntity){
        return productService.updateProduct(
                id,
                productEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
    }
}