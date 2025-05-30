package com.example.EmployManagementSystem.EmsRepository;

import com.example.EmployManagementSystem.EmsEntity.Employs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployRepository extends JpaRepository<Employs, Long> {
    List<Employs> findAllByOrderByIdDesc();
}
