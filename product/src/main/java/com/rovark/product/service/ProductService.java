package com.rovark.product.service;

import com.rovark.product.exception.ProductNotFoundException;
import com.rovark.product.repository.ProductRepository;
import com.rovark.product.entity.ProductEntity;
import org.springframework.stereotype.Service;
import com.rovark.product.exception.ProductNotFoundException;
import java.util.List;
@Service

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService (ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public List<ProductEntity> getAllProducts(){
        return productRepository.findAll();
    }
    public ProductEntity getProductById(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id) );
    }
    public ProductEntity createProduct(ProductEntity productEntity){
        return productRepository.save(productEntity);
    }
    public void deleteProductById(Long id){
        if (! productRepository.existsById(id)){
            throw new ProductNotFoundException(id);
        }
    }

    public  ProductEntity updateProduct(
            Long id,
            ProductEntity productEntity){

        ProductEntity existingProduct = productRepository.findById(id)
                .orElseThrow(
                () -> new ProductNotFoundException(id)
                );
        existingProduct.setName(productEntity.getName());
        existingProduct.setPrice(productEntity.getPrice());
        existingProduct.setCategory(productEntity.getCategory());
        existingProduct.setStock(productEntity.getStock());

        return productRepository.save(existingProduct);
    }
}
