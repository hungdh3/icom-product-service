--liquibase formatted sql
--changeset hungdh:20220824
ALTER TABLE PRODUCT
    ADD PRODUCT_TOTAL_QUALITY integer DEFAULT 0 CHECK (PRODUCT_TOTAL_QUALITY >= 0);
ALTER TABLE PRODUCT
    ADD PRODUCT_REMAIN_QUALITY integer DEFAULT 0 CHECK (PRODUCT_REMAIN_QUALITY >= 0 AND
                                              PRODUCT_REMAIN_QUALITY <= PRODUCT_TOTAL_QUALITY);

-- rollback drop table person;