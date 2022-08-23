package com.icom.product.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "product_id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_category_id", nullable = false)
    private ProductCategoryEntity productCategory;

    @Column(name = "product_branch")
    private String productBranch;

    @Column(name = "product_color")
    private String productColor;

    @Column(name = "PRODUCT_TOTAL_QUALITY")
    private Integer productTotalQuality;

    @Column(name = "PRODUCT_REMAIN_QUALITY")
    private Integer productRemainQuality;

    @Column(name = "product_price")
    private BigDecimal productPrice;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Override
    public String toString() {
        String productCategoryInfo = "(null object)";
        if (null == productCategory) {
            productCategoryInfo = productCategory.toString();
        }
        return "ProductCategoryEntity{" +
                "id=" + id +
                ", product_name='" + productName + '\'' +
                ", product_description='" + productDescription + '\'' +
                ", product_name='" + productName + '\'' +
                ", product_category_id='" + productCategoryInfo + '\'' +
                ", product_branch='" + productBranch + '\'' +
                ", product_color='" + productColor + '\'' +
                ", product_price='" + productTotalQuality + '\'' +
                ", productRemainQuality='" + productRemainQuality + '\'' +
                ", product_price='" + productPrice + '\'' +
                ", created_at='" + createdAt + '\'' +
                ", updated_at='" + updatedAt +
                '}';
    }

    private static boolean containField(String fieldName) {
        //allows some of field sorted
        return ProductEntity_.PRODUCT_NAME.equalsIgnoreCase(fieldName) ||
                ProductEntity_.PRODUCT_BRANCH.equalsIgnoreCase(fieldName) ||
                ProductEntity_.UPDATED_AT.equalsIgnoreCase(fieldName) ||
                ProductEntity_.CREATED_AT.equalsIgnoreCase(fieldName);
    }

    public static String getSearchField(String fieldName) {
        //use default search key if input search key is not valid
        return containField(fieldName) ? fieldName : ProductEntity_.PRODUCT_NAME;
    }
}