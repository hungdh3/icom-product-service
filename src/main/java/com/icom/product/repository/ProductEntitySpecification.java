package com.icom.product.repository;

import com.icom.product.entity.ProductEntity;
import com.icom.product.entity.ProductEntity_;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductEntitySpecification {

    public static Specification<ProductEntity> hasPriceFrom(BigDecimal priceFrom) {
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.greaterThan(root.get(ProductEntity_.productPrice), priceFrom);
    }

    public static Specification<ProductEntity> hasPriceTo(BigDecimal priceTo) {
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.lessThan(root.get(ProductEntity_.productPrice), priceTo);
    }

    public static Specification<ProductEntity> nameLike(String nameLike) {
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.like(root.get(ProductEntity_.productName), "%" + nameLike + "%");
    }

    public static Specification<ProductEntity> descriptionLike(String descriptionLike) {
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.like(root.get(ProductEntity_.productDescription), "%" + descriptionLike + "%");
    }

    public static Specification<ProductEntity> hasCategory(UUID categoryId) {
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.equal(root.get(ProductEntity_.productCategory), categoryId);
    }

    public static Specification<ProductEntity> hasBranch(String branch) {
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.equal(root.get(ProductEntity_.productBranch), branch);
    }

    public static Specification<ProductEntity> hasColor(String color) {
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.equal(root.get(ProductEntity_.productColor), color);
    }
}
