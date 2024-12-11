// package com.pulseup.pulseup_backend.security;

// import java.security.Key;
// import java.util.Date;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Component;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.security.Keys;

// @Component
// public class JwtTokenProvider {

//     private final Key secretKey;
//     private final long expirationTime;

//     // Constructor para inicializar clave y expiración
//     public JwtTokenProvider(@Value("${jwt.expiration}") long expirationTime) {
//         this.secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512); // Clave segura
//         this.expirationTime = expirationTime;
//     }

//     // Generar token JWT
//     public String generateToken(String username) {
//         return Jwts.builder()
//                 .setSubject(username)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
//                 .signWith(secretKey) // Usar clave segura
//                 .compact();
//     }

//     // Validar token JWT
//     public boolean validateToken(String token) {
//         try {
//             Jwts.parserBuilder()
//                 .setSigningKey(secretKey)
//                 .build()
//                 .parseClaimsJws(token);
//             return true;
//         } catch (Exception e) {
//             return false; // Token inválido
//         }
//     }

//     // Extraer el username (subject) del token
//     public String getUsernameFromToken(String token) {
//         Claims claims = Jwts.parserBuilder()
//                 .setSigningKey(secretKey)
//                 .build()
//                 .parseClaimsJws(token)
//                 .getBody();
//         return claims.getSubject();
//     }
// }
