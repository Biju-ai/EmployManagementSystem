--liquibase formatted sql
--changeset biju:1

CREATE  TABLE  IF NOT EXISTS food_list(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    food_name VARCHAR(100) NOT NULL,
    food_price VARCHAR(100) NOT NULL

);