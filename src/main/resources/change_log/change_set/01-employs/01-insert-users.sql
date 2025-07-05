--liquibase formatted sql
--changeset biju:1

INSERT INTO employ_list(
                        first_name,
                        last_name,
                        email_id
)
VALUES(
       "biju",
       "shrestha",
       "biju@gmail.com"
      );

