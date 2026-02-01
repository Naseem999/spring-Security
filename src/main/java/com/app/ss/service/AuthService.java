package com.app.ss.service;

import com.app.ss.dto.LoginDTO;
import com.app.ss.dto.RegisterDTO;
import com.app.ss.entity.Employee;
import com.app.ss.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AuthService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;

    public Employee register(RegisterDTO registerDTO){
        Employee user= new Employee();
        user.setName(registerDTO.getName());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        user.setRole(registerDTO.getRole());
        return  employeeRepository.save(user);

    }


    public Employee authenticate(LoginDTO input){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(input.getEmail(),input.getPassword()));
        return  employeeRepository.findByEmail(input.getEmail());
    }



}
