package com.codeclan.example.employeeservice.repositories;

import com.codeclan.example.employeeservice.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository <Department, Long>{
}
