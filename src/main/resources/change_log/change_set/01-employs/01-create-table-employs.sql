--liquibase formatted sql
--changeset biju:1

CREATE table IF NOT EXISTS employ_list(

    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email_id VARCHAR(100) NOT NULL
);