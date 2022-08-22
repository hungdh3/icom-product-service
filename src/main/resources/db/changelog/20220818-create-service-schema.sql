--liquibase formatted sql
--changeset hungdh:20220817
CREATE TABLE SERVICE (
    SERVICE_ID uuid PRIMARY KEY default uuid_generate_v4(),
    SERVICE_NAME varchar(255) NOT NULL,
    SERVICE_DESCRIPTION varchar(255),
    CREATED_AT timestamp,
    UPDATED_AT timestamp
);
-- rollback drop table person;