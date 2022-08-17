package com.icom.product.repository;

import com.icom.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface ProductEntityRepository
        extends PagingAndSortingRepository<ProductEntity, UUID>, JpaSpecificationExecutor {
}