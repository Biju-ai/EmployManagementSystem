package com.example.EmployManagementSystem.EmsRepository;

import com.example.EmployManagementSystem.EmsEntity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface    FoodRepo extends JpaRepository<Food,Long> {
}
