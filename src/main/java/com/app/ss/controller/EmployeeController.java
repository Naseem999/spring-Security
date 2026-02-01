package com.app.ss.controller;

import com.app.ss.entity.Employee;
import com.app.ss.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/employees")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public String getEmployee(){
        return "employees";
    }

    @GetMapping("/home")
    public String getHome(){
        return "Home";
    }

    @GetMapping("/employees/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Employee> getAllEmp(){
        return service.getAllEmloyees();
    }



}
