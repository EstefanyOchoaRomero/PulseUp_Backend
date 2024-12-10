package com.pulseup.pulseup_backend.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long expirationTime;

    
    public String generateToken(String username) {
        // Date now = new Date();
        // Date expirationDate = new Date(now.getTime() + expirationTime);
        return generateToken(username);
        // return Jwts.builder()
        //         .setSubject(username)
        //         .setIssuedAt(now)
        //         .setExpiration(expirationDate)
        //         .signWith(SignatureAlgorithm.HS512, secretKey)
        //         .compact();
    }


    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    
    public boolean validateToken(String token) {
        try {
            
            Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
        
            return false;
        }
    }

    
    public Date getExpirationDateFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
        return claims.getExpiration();
    }
}
