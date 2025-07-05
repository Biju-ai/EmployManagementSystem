package com.example.EmployManagementSystem.EmsController;

import com.example.EmployManagementSystem.EmsDto.Request.CardItemDto;
import com.example.EmployManagementSystem.EmsDto.Request.DeleteEmployesById;
import com.example.EmployManagementSystem.EmsDto.Request.InsertEmployDto;
import com.example.EmployManagementSystem.EmsDto.Responce.EmployFindById;
import com.example.EmployManagementSystem.EmsDto.Responce.UpdateEmploysDetail;
import com.example.EmployManagementSystem.EmsEntity.CardItem;
import com.example.EmployManagementSystem.EmsEntity.Food;
import com.example.EmployManagementSystem.EmsService.CartService;
import com.example.EmployManagementSystem.EmsService.Employserver;
import com.example.EmployManagementSystem.EmsService.FoodService;
import com.example.EmployManagementSystem.Util.ApiResponce;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin("*")
@RestController
@RequestMapping("api/employs")
public class EmployController {
    private final Employserver employserver;

    private final CartService cartService;
    private final FoodService foodService;

    public EmployController(Employserver employserver, CartService cartService, FoodService foodService) {
        this.employserver = employserver;
        this.cartService = cartService;
        this.foodService = foodService;
    }
        @PostMapping("/insertEmploy")
    public ApiResponce<?> insertemploy(@RequestBody InsertEmployDto insertEmployDto) {
        return employserver.insertdata(insertEmployDto);
    }
    @PostMapping("/findById")
    public ApiResponce<?> findById(@RequestBody EmployFindById employFindById) {
        return employserver.findById(employFindById);
    }
    @PostMapping("/findAll")
    public  ApiResponce<?> findALl() {
        return employserver.findall();
    }
    @PostMapping("/modify")
    public ApiResponce<?> modifyEmploy(@RequestBody UpdateEmploysDetail updateEmploysDetail) {
        return employserver.updateEmploys(updateEmploysDetail);
    }
    @PostMapping("/deleteById")
    public ApiResponce<?> deleteEmploy(@RequestBody DeleteEmployesById deleteEmployesById) {
        return employserver.deleteById(deleteEmployesById);
    }


    // adding the product

    @PostMapping("/addToCart")
    public String addtocart(@RequestBody CardItemDto cardItemDto) {
        return cartService.addtocart(cardItemDto);
    }
    @PostMapping("/addfood")
    public ApiResponce<?> addfood(@RequestBody Food food) {
        return foodService.addFood(food);
    }


}
