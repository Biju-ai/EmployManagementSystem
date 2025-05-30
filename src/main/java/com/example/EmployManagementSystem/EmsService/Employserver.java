package com.example.EmployManagementSystem.EmsService;

import com.example.EmployManagementSystem.EmsDto.Request.DeleteEmployesById;
import com.example.EmployManagementSystem.EmsDto.Responce.FindAllEmploys;
import com.example.EmployManagementSystem.EmsDto.Request.InsertEmployDto;
import com.example.EmployManagementSystem.EmsDto.Responce.EmployFindById;
import com.example.EmployManagementSystem.EmsDto.Responce.UpdateEmploysDetail;
import com.example.EmployManagementSystem.EmsEntity.Employs;
import com.example.EmployManagementSystem.EmsRepository.EmployRepository;
import com.example.EmployManagementSystem.Util.ApiResponce;
import com.example.EmployManagementSystem.Util.ResponceUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Employserver {
    private final EmployRepository employRepository;

    public Employserver(EmployRepository employRepository) {
        this.employRepository = employRepository;
    }

    public ApiResponce<?> insertdata(InsertEmployDto insertEmployDto) {
        Employs employs = new Employs();

        employs.setFirstName(insertEmployDto.getFirstName());
        employs.setLastName(insertEmployDto.getLastName());
        employs.setEmail(insertEmployDto.getEmail());
        employRepository.save(employs);
        return ResponceUtil.getSuccessMsg(1,"Employs Information Added Successfully ");
    }
    public  ApiResponce<?> findById(EmployFindById employFindById) {
        Employs employs = employRepository.findById(employFindById.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"The id is not found"));
        return ResponceUtil.getSuccessMsg(1,"Employs Information Find Successfully4 ",employs);
    }
    public ApiResponce<?> findall() {
        List<Employs> employs = employRepository.findAllByOrderByIdDesc();
        List<FindAllEmploys> findEmploys = new ArrayList<>();
        for (Employs employ : employs) {
            FindAllEmploys findAllEmploy = new FindAllEmploys();
            findAllEmploy.setId(employ.getId());
            findAllEmploy.setFirstName(employ.getFirstName());
            findAllEmploy.setLastName(employ.getLastName());
            findAllEmploy.setEmail(employ.getEmail());
            findEmploys.add(findAllEmploy);
        }
        if (!findEmploys.isEmpty()) {

            return ResponceUtil.getSuccessMsg(1,"Employs Information Find Successfully ",findEmploys);
        }
        else  {
            return ResponceUtil.getSuccessMsg(1,"Employs Information Not Find ");
        }

    }
    public ApiResponce<?> deleteById(DeleteEmployesById deleteEmployesById) {
        long id= deleteEmployesById.getId();
        Optional<Employs> employs = employRepository.findById(id);
        if (employs.isPresent()) {
            employRepository.deleteById(id);
            return ResponceUtil.getSuccessMsg(1,"Employs Information Delete Successfully ");
        }
        return ResponceUtil.getSuccessMsg(1,"Employs Information Delete Failed ");
    }


    public ApiResponce<?> updateEmploys(UpdateEmploysDetail updateEmploysDetail) {
        long id=updateEmploysDetail.getId();
        Optional<Employs> employs = employRepository.findById(id);

        if (employs.isPresent()) {
            Employs employ = employs.get();

            //modify

            employ.setFirstName(updateEmploysDetail.getFirstName());
            employ.setLastName(updateEmploysDetail.getLastName());
            employ.setEmail(updateEmploysDetail.getEmail());
           employRepository.save(employ);
           return ResponceUtil.getSuccessMsg(1,"Employs Information Update Successfully ");

        }
        return ResponceUtil.getSuccessMsg(1,"Employs Information Update Failed ");

    }

}
