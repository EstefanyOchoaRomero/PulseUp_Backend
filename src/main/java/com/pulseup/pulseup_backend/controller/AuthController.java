package com.pulseup.pulseup_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }


    
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationDTO userDTO) {
        try {
            User registeredUser = userService.registerUser(userDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> authenticateUser(@RequestBody UserLoginDTO loginDTO) {
        try {
        
            User user = userService.authenticateUser(loginDTO);

            
            String token = jwtTokenProvider.generateToken(user.getCorreoElectronico());

            
            return ResponseEntity.ok(new AuthResponseDTO(token));
        } catch (Exception e) {
            return ResponseEntity.status(401).body(new AuthResponseDTO("Invalid credentials"));
        }
    }
}