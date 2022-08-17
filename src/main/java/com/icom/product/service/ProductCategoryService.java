package com.icom.product.service;

import com.icom.product.entity.ProductCategoryEntity;
import com.icom.product.model.PageInfo;
import com.icom.product.repository.ProductCategoryEntityRepository;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryEntityRepository productCategoryEntityRepository;

    public Page<ProductCategoryEntity> getProductCategories(@NonNull PageInfo pageInfo) {
        //handle the case request inputs wrong sort-key
        String searchKey = ProductCategoryEntity.getSearchField(pageInfo.getKey());
        Sort plantSort = pageInfo.buildSort(searchKey);
        Pageable page = PageRequest.of(pageInfo.getPage(),
                pageInfo.getElementPerPage(),
                plantSort);

        return productCategoryEntityRepository.findAll(page);
    }
}
