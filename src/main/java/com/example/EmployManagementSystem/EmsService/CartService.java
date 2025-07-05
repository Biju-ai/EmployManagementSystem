package com.example.EmployManagementSystem.EmsService;

import com.example.EmployManagementSystem.EmsDto.Request.CardItemDto;
import com.example.EmployManagementSystem.EmsEntity.CardItem;
import com.example.EmployManagementSystem.EmsEntity.Cart;
import com.example.EmployManagementSystem.EmsEntity.Employs;
import com.example.EmployManagementSystem.EmsEntity.Food;
import com.example.EmployManagementSystem.EmsRepository.CartItemRepo;
import com.example.EmployManagementSystem.EmsRepository.CartRepo;
import com.example.EmployManagementSystem.EmsRepository.EmployRepository;
import com.example.EmployManagementSystem.EmsRepository.FoodRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    private final EmployRepository employRepository;
    private final CartItemRepo cartItemRepo;
    private final FoodRepo foodRepo;
    private final CartRepo cartRepo;

    public CartService(EmployRepository employRepository, CartItemRepo cartItemRepo, FoodRepo foodRepo, CartRepo cartRepo) {
        this.employRepository = employRepository;
        this.cartItemRepo = cartItemRepo;
        this.foodRepo = foodRepo;
        this.cartRepo = cartRepo;
    }
    public String addtocart(CardItemDto dto){
        int quantity = (dto.getQuantity()==null ||dto.getQuantity()<1)?1:dto.getQuantity();

        if(quantity>5){
            return "you cant add more than 5 at once";
        }
        Optional<Food> food = foodRepo.findById(dto.getFoodid());

        if(!food.isPresent()){
            return "food item is not found";
        }

        Optional<Cart> cartDbNew = cartRepo.findById(dto.getCartid());
        Cart cartDb = null;
        if (cartDbNew.isEmpty()) {
            Cart cart1 = new Cart();
            cart1.setEmploys( employRepository.findById(1L).orElseThrow(null));
            cartDb = cartRepo.save(cart1);
        }


        CardItem cardItem = cartItemRepo.findByCartAndFood(cartDb, food.get());
        if(cardItem != null) {
            int newQuantity =cardItem.getQuantity()+quantity;
            if (newQuantity > 5) {
                return "you cant add more than 5 at once";
            }
            cardItem.setQuantity(newQuantity);
            cartItemRepo.save(cardItem);
        }else{
                CardItem cardItem1 = new CardItem();
                cardItem1.setFood(food.get());
                cardItem1.setCart(cartDb);
                cardItem1.setQuantity(quantity);
            cartItemRepo.save(cardItem1);

        }
       return  "success";
    }

    }


