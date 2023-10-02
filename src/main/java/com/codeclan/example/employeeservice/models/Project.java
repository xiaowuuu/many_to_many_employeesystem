package com.codeclan.example.employeeservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "duration")
    private  String duration;
    @Column(name = "name")
    private String name;
    @ManyToMany
    @JsonIgnoreProperties({"projects"})
    @Cascade({CascadeType.SAVE_UPDATE})

    @JoinTable(
            name = "employee_projects",
            joinColumns = {
                    @JoinColumn(
                            name = "project_id",
                            nullable = false,
                            updatable = false
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "employee_id",
                            nullable = false,
                            updatable = false
                    )
            }
    )
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Project(String name, String duration) {
        this.name = name;
        this.duration = duration;
        this.employees = new ArrayList<>();
    }
    public Project(){

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }
}
