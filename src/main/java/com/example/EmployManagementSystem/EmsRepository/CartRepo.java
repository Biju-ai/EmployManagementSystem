package com.example.EmployManagementSystem.EmsRepository;

import com.example.EmployManagementSystem.EmsEntity.Cart;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartRepo extends JpaRepository<Cart,Long> {

}
