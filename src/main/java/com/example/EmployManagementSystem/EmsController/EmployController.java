package com.example.EmployManagementSystem.EmsController;

import com.example.EmployManagementSystem.EmsDto.Request.DeleteEmployesById;
import com.example.EmployManagementSystem.EmsDto.Request.InsertEmployDto;
import com.example.EmployManagementSystem.EmsDto.Responce.EmployFindById;
import com.example.EmployManagementSystem.EmsDto.Responce.UpdateEmploysDetail;
import com.example.EmployManagementSystem.EmsService.Employserver;
import com.example.EmployManagementSystem.Util.ApiResponce;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin("*")
@RestController
@RequestMapping("api/employs")
public class EmployController {
    private final Employserver employserver;
    public EmployController(Employserver employserver) {
        this.employserver = employserver;
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
}
