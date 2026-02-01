package com.app.ss.service;

import com.app.ss.entity.Employee;
import com.app.ss.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo){
      this.repo=repo;
    }

    public List<Employee> getAllEmloyees(){
            return repo.findAll();
    }


}
