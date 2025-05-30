package com.example.EmployManagementSystem.EmsDto.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class InsertEmployDto {
    private String firstName;
    private String lastName;
    private String email;

}
