package com.pulseup.pulseup_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pulseup.pulseup_backend.dto.AuthResponseDTO;
import com.pulseup.pulseup_backend.dto.UserLoginDTO;
import com.pulseup.pulseup_backend.dto.UserRegistrationDTO;
import com.pulseup.pulseup_backend.models.User;
import com.pulseup.pulseup_backend.security.JwtTokenProvider;
import com.pulseup.pulseup_backend.service.UserService;

import jakarta.validation.Valid;
    
    @RestController
    @RequestMapping("/api/auth")
    public class AuthController {
    
        private final UserService userService;
    
        @Autowired
        private JwtTokenProvider jwtTokenProvider;
    
        @Autowired
        private AuthenticationManager authenticationManager;  // Agregar AuthenticationManager
    
        @Autowired
        public AuthController(UserService userService) {
            this.userService = userService;
        }
    
    
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> authenticateUser(@RequestBody @Valid UserLoginDTO loginDTO) {
        try {
            // Autenticación usando Spring Security
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    loginDTO.getCorreoElectronico(),
                    loginDTO.getContrasena()
                )
            );

            // Generar token JWT
            String token = jwtTokenProvider.generateToken(authentication.getName());

            // Responder con el token
            return ResponseEntity.ok(new AuthResponseDTO(token));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body(new AuthResponseDTO("Invalid email or password"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new AuthResponseDTO("An unexpected error occurred"));
        }
    }


        @PostMapping("/register")
        public ResponseEntity<?> registerUser(@RequestBody UserRegistrationDTO userDTO) {
            try {
                // Registro de usuario
                User registeredUser = userService.registerUser(userDTO);
    
                // Evitar exponer información sensible (como contraseñas)
                return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser.getCorreoElectronico());
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
            }
        }
    
    }


    