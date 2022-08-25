package com.icom.product.controller;

import brave.internal.Nullable;
import com.icom.product.entity.ProductEntity;
import com.icom.product.model.PageInfo;
import com.icom.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.UUID;

@Slf4j
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/v1/products", produces = "application/json")
    public ResponseEntity<?> getAllProduct(BigDecimal priceFrom,
                                           BigDecimal priceTo,
                                           String nameLike,
                                           String descriptionLike,
                                           @Nullable String categoryId,
                                           String branch,
                                           String color,
                                           PageInfo page) {
        UUID categoryUuid = null;
        if (null != categoryId && !categoryId.trim().equalsIgnoreCase("")) {
            categoryUuid = UUID.fromString(categoryId);
        }
        Page<ProductEntity> productEntities
                = productService.searchProduct(priceFrom,
                priceTo, nameLike, descriptionLike, categoryUuid, branch, color, page);
        log.info("getAllProductCategories");
        //@TODO: return sorted key
        return ResponseEntity.ok(productEntities);
    }
}
