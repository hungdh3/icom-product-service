package com.icom.product.repository;

import com.icom.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductEntityRepository extends JpaRepository<ProductEntity, UUID> {
}