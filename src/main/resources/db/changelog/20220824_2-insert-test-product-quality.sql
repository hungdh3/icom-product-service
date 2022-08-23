--liquibase formatted sql
--changeset hungdh:20220824_2
UPDATE PRODUCT
SET PRODUCT_TOTAL_QUALITY  = 10,
    PRODUCT_REMAIN_QUALITY = 3
-- rollback drop table person;