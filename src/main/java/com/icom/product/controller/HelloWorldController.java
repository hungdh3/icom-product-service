package com.icom.product.controller;

import com.icom.product.entity.ProductCategoryEntity;
import com.icom.product.repository.ProductCategoryEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class HelloWorldController {

    @Autowired
    private ProductCategoryEntityRepository productCategoryEntityRepository;

    @GetMapping("/hello")
    String sayHello() {
        List<ProductCategoryEntity> prodCategories = productCategoryEntityRepository.findAll();
        prodCategories.forEach(e -> {
            log.info(e.getProductCategoryName());
        });
        log.info("---------");
        return "Hello World";
    }
}
