package com.icom.product.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.web.SortDefault;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Table(name = "product_category")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductCategoryEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "product_category_id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "product_category_name", nullable = false)
    private String productCategoryName;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Override
    public String toString() {
        return "ProductCategoryEntity{" +
                "id=" + id +
                ", product_category_name='" + productCategoryName + '\'' +
                ", created_at='" + createdAt + '\'' +
                ", updated_at='" + updatedAt +
                '}';
    }

    private static boolean containField(String fieldName) {
        //allows some of field sorted
        return "productCategoryName".equalsIgnoreCase(fieldName) ||
                "created_at".equalsIgnoreCase(fieldName) ||
                "updated_at".equalsIgnoreCase(fieldName);
    }

    public static String getSearchField(String fieldName) {
        //use default search key if input search key is not valid
        return containField(fieldName) ? fieldName : "productCategoryName";
    }
}