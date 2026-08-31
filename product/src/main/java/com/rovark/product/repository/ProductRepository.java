package com.rovark.product.repository;

import com.rovark.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends  JpaRepository<ProductEntity, Long>
{

}
