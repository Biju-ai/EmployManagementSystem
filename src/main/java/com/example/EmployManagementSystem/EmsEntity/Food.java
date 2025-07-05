package com.example.EmployManagementSystem.EmsEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name="food_list")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "food_name",nullable = false,length=100)
    private String name;


    @Column(name ="food_price",nullable = false,length = 100)
    private String price;

}
