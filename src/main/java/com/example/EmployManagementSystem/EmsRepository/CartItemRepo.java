package com.example.EmployManagementSystem.EmsRepository;

import com.example.EmployManagementSystem.EmsEntity.CardItem;
import com.example.EmployManagementSystem.EmsEntity.Cart;
import com.example.EmployManagementSystem.EmsEntity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepo extends JpaRepository<CardItem,Long> {


    CardItem findByCart_IdAndFood_Id(Long cartId, Long foodId);

    CardItem findByCartAndFood(Cart cart, Food food);
}
