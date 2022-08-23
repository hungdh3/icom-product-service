package com.icom.product.controller;

import com.icom.product.entity.ProductCategoryEntity;
import com.icom.product.model.PageInfo;
import com.icom.product.service.ProductCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
@Api(tags = "Product Category Rest Service")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping(value = "/v1/product/categories", produces = "application/json")
    @ApiOperation(value = "Get Products")
    public ResponseEntity<?> getAllProductCategories(PageInfo page) {
        Page<ProductCategoryEntity> productCategoryEntities = productCategoryService.getProductCategories(page);
        log.info("getAllProductCategories");
        //@TODO: return sorted key
        return ResponseEntity.ok(productCategoryEntities);
    }
}
