package com.app.ss.controller;

import com.app.ss.dto.LoginDTO;
import com.app.ss.dto.RegisterDTO;
import com.app.ss.entity.Employee;
import com.app.ss.service.AuthService;
import com.app.ss.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    JwtService jwtService;


    @PostMapping("/register")
    public Employee register(@RequestBody RegisterDTO registerDto) {
        Employee user = authService.register(registerDto);
        return user;
    }


    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO) {
        Employee user = authService.authenticate(loginDTO);
        String token = jwtService.generateToken(user);
        return token;
    }


}
