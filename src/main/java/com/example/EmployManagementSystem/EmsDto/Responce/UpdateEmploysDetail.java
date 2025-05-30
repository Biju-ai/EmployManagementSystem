package com.example.EmployManagementSystem.EmsDto.Responce;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateEmploysDetail {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

}
