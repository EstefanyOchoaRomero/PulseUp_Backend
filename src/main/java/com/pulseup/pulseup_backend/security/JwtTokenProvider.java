package com.pulseup.pulseup_backend.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")  // Secret key para firmar los tokens
    private String secretKey;

    @Value("${jwt.expiration}")  // Tiempo de expiración del token en milisegundos
    private long expirationTime;

    // Genera un token JWT con el nombre de usuario
    public String generateToken(String username) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + expirationTime);

        return Jwts.builder()
                .setSubject(username)  // Establece el nombre de usuario en el token
                .setIssuedAt(now)  // Fecha de emisión
                .setExpiration(expirationDate)  // Fecha de expiración
                .signWith(SignatureAlgorithm.HS512, secretKey)  // Firma el token con el secretKey
                .compact();  // Devuelve el token compactado
    }

    // Obtiene el nombre de usuario a partir del token JWT
    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();  // Devuelve el nombre de usuario
    }

    // Verifica si el token es válido
    public boolean validateToken(String token) {
        try {
            // Verifica que el token no haya expirado y que la firma sea válida
            Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            // Si hay algún error en la validación (token expirado, firma inválida, etc.), devuelve false
            return false;
        }
    }

    // Extrae la fecha de expiración del token
    public Date getExpirationDateFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
        return claims.getExpiration();
    }
}
