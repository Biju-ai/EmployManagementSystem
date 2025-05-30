package com.example.EmployManagementSystem.EmsEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employ_list")
public class Employs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name ="email_id", unique = true, nullable = false)
    private String email;



}
