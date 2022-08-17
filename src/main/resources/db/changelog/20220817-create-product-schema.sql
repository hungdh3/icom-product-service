--liquibase formatted sql
--changeset hungdh:20220817
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE PRODUCT_CATEGORY (
    PRODUCT_CATEGORY_ID uuid PRIMARY KEY default uuid_generate_v4(),
    PRODUCT_CATEGORY_NAME varchar(255) NOT null,
    CREATED_AT timestamp,
    UPDATED_AT timestamp
);
CREATE TABLE PRODUCT (
    PRODUCT_ID uuid PRIMARY KEY default uuid_generate_v4(),
    PRODUCT_NAME varchar(255) NOT NULL,
    PRODUCT_DESCRIPTION varchar(255),
    PRODUCT_CATEGORY_ID uuid NOT NULL,
    CREATED_AT timestamp,
    UPDATED_AT timestamp,
    CONSTRAINT PRODUCT_CATEGORY_ID_REF FOREIGN KEY(PRODUCT_CATEGORY_ID)
        REFERENCES PRODUCT_CATEGORY(PRODUCT_CATEGORY_ID)
);

-- rollback drop table person;