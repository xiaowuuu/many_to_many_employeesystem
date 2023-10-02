package com.codeclan.example.employeeservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "employee_number")
    private String employeeNumber;
    @Column(name = "email")
    private String email;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    @JsonIgnoreProperties({"employee"})
    private Department department;

    @ManyToMany
    @JoinTable(
            name = "employee_projects",
            joinColumns = {
                    @JoinColumn(
                            name = "employee_id",
                            nullable = false,
                            updatable = false
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "project_id",
                            nullable = false,
                            updatable = false
                    )
            }
    )
    private List<Project> projects;

    public List<Project> getProject() {
        return projects;
    }
    public void setProject(List<Project> projects) {
        this.projects = projects;
    }


    public Employee(String name, int age, String employeeNumber, String email, Department department) {
        this.name = name;
        this.age = age;
        this.employeeNumber = employeeNumber;
        this.email = email;
        this.department = department;
        this.projects = new ArrayList<>();
    }

    public Department getDepartment(){
        return department;
    }
    public void setDepartment(Department department){
        this.department = department;
    }
    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addProject(Project project) {
        this.projects.add(project);
    }


}
