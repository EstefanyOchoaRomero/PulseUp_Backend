package com.pulseup.pulseup_backend.security;



import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;


@Component
public class JwtTokenUtil {

    private final String jwtSecret = "TuClaveSecreta"; // Cambia esto por una clave fuerte
    private final long jwtExpirationMs = 3600000; // 1 hora en milisegundos

    public String generateToken(String username) {
        Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    
    // Crear el JWT con la clave generada
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(secretKey)  // Usar la clave generada aquí
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
