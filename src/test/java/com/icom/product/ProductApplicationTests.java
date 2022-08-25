package com.icom.product;

import com.icom.product.entity.ProductCategoryEntity;
import com.icom.product.repository.ProductCategoryEntityRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductApplication.class)
@ActiveProfiles("test")
class ProductApplicationTests {

    @Autowired
    private ProductCategoryEntityRepository productCategoryEntityRepository;

    @Test
    public void test_insert_and_retrieve_data_for_unittest_postgres_container() {
        ProductCategoryEntity productCategory = new ProductCategoryEntity();
        productCategory.setProductCategoryName("test product name");
        productCategoryEntityRepository.save(productCategory);

        Iterable<ProductCategoryEntity> all = productCategoryEntityRepository.findAll();
        int counter = 0;
        for (Object i : all) {
            counter++;
        }
        assertThat(counter).isEqualTo(1);
    }

}
