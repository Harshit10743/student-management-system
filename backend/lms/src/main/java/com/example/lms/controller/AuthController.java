package com.example.lms.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lms.dto.LoginRequestDTO;

@RestController
@RequestMapping("/auth")
@CrossOrigin("http://localhost:5173")
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDTO dto) {
    
	   if(dto.getUsername().equals("admin") && dto.getPassword().equals("admin"))         {
            return "JWT_TOKEN";
        }

        return "Invalid Credentials";
    }
}