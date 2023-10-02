package com.codeclan.example.employeeservice;

import com.codeclan.example.employeeservice.models.Department;
import com.codeclan.example.employeeservice.models.Employee;
import com.codeclan.example.employeeservice.models.Project;
import com.codeclan.example.employeeservice.repositories.DepartmentRepository;
import com.codeclan.example.employeeservice.repositories.EmployeeRepository;
import com.codeclan.example.employeeservice.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeserviceApplicationTests {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	ProjectRepository projectRepository;

	@Test
	void contextLoads() {
	}
	@Test
	public void createEmployee(){
		Department department = new Department("SDE");
		departmentRepository.save(department);
		Employee employee1 = new Employee("ying", 20, "trt352525", "huay@gmail.com", department);
		employeeRepository.save(employee1);
		Project project1 = new Project("final project", "12 days");
		project1.addEmployee(employee1);
		projectRepository.save(project1);

	}

}
