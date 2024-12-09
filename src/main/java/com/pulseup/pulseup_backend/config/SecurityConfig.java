package com.pulseup.pulseup_backend.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.pulseup.pulseup_backend.dto.UserLoginDTO;
import com.pulseup.pulseup_backend.models.User;
import com.pulseup.pulseup_backend.repository.UserRepository;
import com.pulseup.pulseup_backend.security.JwtAuthenticationFilter;

import lombok.Data;




@Data
@EnableWebSecurity
@Configuration


public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    @Autowired
    private UserRepository userRepository;


    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeHttpRequests(authorize -> authorize
            .requestMatchers(request -> request.getRequestURI().equals("/api/auth/register")).permitAll()
                .anyRequest().authenticated())
            .httpBasic();
        return http.build();
    }

    @Autowired
    private PasswordEncoder passwordEncoder;
    public User authenticateUser(UserLoginDTO userDTO) {
        String encodedPassword = passwordEncoder.encode(userDTO.getContrasena());
        Optional<User> usuario = userRepository.findByCorreoElectronico(userDTO.getCorreoElectronico());
        if (usuario.isPresent() && passwordEncoder.matches(encodedPassword, usuario.get().getContrasena())) {
            return usuario.get();
        }
        throw new RuntimeException("Invalid credentials");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("http://localhost:8080");  // Asegúrate de usar el origen correcto
    }
}
