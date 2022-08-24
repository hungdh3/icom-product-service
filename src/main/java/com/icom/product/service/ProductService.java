package com.icom.product.service;

import com.icom.product.entity.ProductEntity;
import com.icom.product.kafka.ItemCreatedEvent;
import com.icom.product.model.PageInfo;
import com.icom.product.repository.ProductEntityRepository;
import com.icom.product.repository.ProductEntitySpecification;
import com.icom.product.util.JsonUtil;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Slf4j
@Service
public class ProductService {

    @Autowired
    private ProductEntityRepository productEntityRepository;

    public Page<ProductEntity> searchProduct(BigDecimal priceFrom,
                                             BigDecimal priceTo,
                                             String nameLike,
                                             String descriptionLike,
                                             UUID categoryId,
                                             String branch,
                                             String color,
                                             @NonNull PageInfo pageInfo) {
        //handle the case request inputs wrong sort-key
        String searchKey = ProductEntity.getSearchField(pageInfo.getKey());
        Sort plantSort = pageInfo.buildSort(searchKey);
        Pageable page = PageRequest.of(pageInfo.getPage(),
                pageInfo.getElementPerPage(),
                plantSort);

        Specification<ProductEntity> searchSpec;
        //init spec
        if (priceFrom.compareTo(BigDecimal.ZERO) > 0) {
            searchSpec = ProductEntitySpecification.hasPriceFrom(priceFrom);
        } else {
            searchSpec = ProductEntitySpecification.hasPriceFrom(BigDecimal.ZERO);
        }
        if (priceTo.compareTo(BigDecimal.ZERO) > 0) {
            searchSpec.and(ProductEntitySpecification.hasPriceTo(priceTo));
        }
        if (null != nameLike && !nameLike.isEmpty()) {
            searchSpec.and(ProductEntitySpecification.nameLike(nameLike));
        }
        if (null != descriptionLike && !descriptionLike.isEmpty()) {
            searchSpec.and(ProductEntitySpecification.descriptionLike(descriptionLike));
        }
        if (null != categoryId) {
            searchSpec.and(ProductEntitySpecification.hasCategory(categoryId));
        }
        if (null != branch && !branch.isEmpty()) {
            searchSpec.and(ProductEntitySpecification.hasBranch(branch));
        }
        if (null != color && !color.isEmpty()) {
            searchSpec.and(ProductEntitySpecification.hasColor(color));
        }
        return productEntityRepository.findAll(searchSpec, page);
    }

    @KafkaListener(topics = "${icom.cart.item-created-topic.name}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "kafkaListenerContainerFactory")
    public void itemCreatedEvent(String message) {
        log.info("------ Received Message from Kafka: " + message);
        ItemCreatedEvent event = (ItemCreatedEvent) JsonUtil.stringToObject(message, ItemCreatedEvent.class);
        log.info("------ Object Received: " + event.toString());

    }
}
