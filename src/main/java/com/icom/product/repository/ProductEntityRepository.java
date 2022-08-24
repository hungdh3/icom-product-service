package com.icom.product.repository;

import com.icom.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface ProductEntityRepository
        extends PagingAndSortingRepository<ProductEntity, UUID>, JpaSpecificationExecutor {
    @Transactional
    @Modifying
    @Query(value = " UPDATE product product_remain_quality " +
            "   SET product_remain_quality =product_remain_quality - :number  " +
            "   WHERE product_id = :id",
            nativeQuery = true)
    void consumeProduct(UUID id, Integer number);
}