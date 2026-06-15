package com.example.lms.service;

import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import io.jsonwebtoken.security.Keys;
@Service
public class JWTService {
    @Value("${jwt.secret}")
    private String Key;
    public String generateJwtToken (String username) {
        String token =

        Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis()+ 1000*60*30))
                .signWith(Keys.hmacShaKeyFor(Key.getBytes()))
                .compact();
        return token;
    }
}