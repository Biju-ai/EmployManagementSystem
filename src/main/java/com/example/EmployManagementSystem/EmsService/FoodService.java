package com.example.EmployManagementSystem.EmsService;

import com.example.EmployManagementSystem.EmsEntity.Food;
import com.example.EmployManagementSystem.EmsRepository.FoodRepo;
import com.example.EmployManagementSystem.Util.ApiResponce;
import com.example.EmployManagementSystem.Util.ResponceUtil;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

    private final FoodRepo foodRepo;

    public FoodService(FoodRepo foodRepo) {
        this.foodRepo = foodRepo;
    }
    public ApiResponce<?> addFood(Food food) {
        Food food1 = new  Food();
     food1.setName(food.getName());
     food1.setPrice(food.getPrice());
     foodRepo.save(food1);
     return ResponceUtil.getSuccessMsg(1,"Food added successfully",food1);
    }
}
