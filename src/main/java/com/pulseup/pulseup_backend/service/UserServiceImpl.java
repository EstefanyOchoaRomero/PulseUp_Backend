package com.pulseup.pulseup_backend.service;




import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pulseup.pulseup_backend.dto.UserLoginDTO;
import com.pulseup.pulseup_backend.dto.UserRegistrationDTO;
import com.pulseup.pulseup_backend.models.User;
import com.pulseup.pulseup_backend.repository.UserRepository;

import lombok.Data;

@Data

@Service

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public User registerUser(UserRegistrationDTO userDTO) {

        String encodedPassword = passwordEncoder.encode(userDTO.getContrasena());
        
        User user = new User();
        user.setNombre(userDTO.getNombre());
        user.setApellido(userDTO.getApellido());
        user.setApodo(userDTO.getApodo());
        user.setGustoMusical(userDTO.getGustoMusical());
        user.setEstiloVestir(userDTO.getEstiloVestir());
        user.setCorreoElectronico(userDTO.getCorreoElectronico());
        user.setContrasena(encodedPassword);
    
        return userRepository.save(user);


        
    }

        
    @Override
    public User authenticateUser(UserLoginDTO userDTO) {
        String encodedPassword = passwordEncoder.encode(userDTO.getContrasena());
        Optional<User> usuario = userRepository.findByCorreoElectronico(userDTO.getCorreoElectronico());
        if (usuario.isPresent() && passwordEncoder.matches(encodedPassword, usuario.get().getContrasena())) {
            return usuario.get();
        }
        throw new RuntimeException("Invalid credentials");
    }
}



