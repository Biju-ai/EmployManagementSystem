--liquibase formatted sql
--changeset biju:1

INSERT INTO food_list(
                      food_name,
                      food_price)
VALUES(
       "apple",
       "200"
      );
