package com.codeclan.example.employeeservice.EmployeeControllers;

import com.codeclan.example.employeeservice.models.Employee;
import com.codeclan.example.employeeservice.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;
    @GetMapping(value = "/employee")
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }
    @GetMapping(value = "/employee/{id}")
    public Optional<Employee> getEmployee(@PathVariable Long id) {
        return employeeRepository.findById(id);
    }
}
