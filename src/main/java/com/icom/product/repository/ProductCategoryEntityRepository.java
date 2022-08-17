package com.icom.product.repository;

import com.icom.product.entity.ProductCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface ProductCategoryEntityRepository extends PagingAndSortingRepository<ProductCategoryEntity, UUID> {
}