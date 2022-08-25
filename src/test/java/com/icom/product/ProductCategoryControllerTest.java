package com.icom.product;

import com.icom.product.entity.ProductCategoryEntity;
import com.icom.product.repository.ProductCategoryEntityRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductApplication.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class ProductCategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductCategoryEntityRepository productCategoryEntityRepository;

    @Test
    public void test_insert_and_retrieve_data_for_unittest_postgres_container() {
        //ARRANGE
        ProductCategoryEntity productCategory = new ProductCategoryEntity();
        productCategory.setProductCategoryName("test product name");
        productCategoryEntityRepository.save(productCategory);
        productCategory = new ProductCategoryEntity();
        productCategory.setProductCategoryName("test product name 2");
        productCategoryEntityRepository.save(productCategory);
        //ACT
        Iterable<ProductCategoryEntity> all = productCategoryEntityRepository.findAll();
        int counter = 0;
        for (Object i : all) {
            counter++;
        }
        //ASSERT
        assertThat(counter).isEqualTo(12);
    }

    @Test
    public void test_get_all_product() throws Exception {
        //ARRANGE - data from liquibase
        final String GET_ALL_PRODUCT_URL = "/v1/products?priceFrom=0&priceTo=1000&nameLike=PRODUCT-NAME&descriptionLike=DESCRIPTION&branch=branch%201&color=RED&page=0&elementPerPage=5&direction=asc&key=PRODUCT_NAME";
        //ACT
        ResultActions response = mockMvc.perform(
                MockMvcRequestBuilders.get(GET_ALL_PRODUCT_URL)
                        .contentType(MediaType.APPLICATION_JSON));
        //ASSERT
        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString("PRODUCT DESCRIPTION")));
    }
}
