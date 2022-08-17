package com.icom.product.repository;

import com.icom.product.entity.ProductCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductCategoryEntityRepository extends JpaRepository<ProductCategoryEntity, UUID> {
}