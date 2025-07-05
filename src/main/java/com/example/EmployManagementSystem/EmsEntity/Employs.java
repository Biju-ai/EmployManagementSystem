package com.example.EmployManagementSystem.EmsEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="employ_list")
public class Employs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "first_name",nullable = false,length = 100)
    private String firstname;
    @Column(name = "last_name",nullable = false,length = 100)
    private String lastname;
    @Column(name ="email_id", unique = true, nullable = false,length = 100)
    private String email;

}
