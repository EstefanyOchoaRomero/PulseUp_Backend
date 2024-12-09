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

    

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    

    public User updateUser(Long userId, UserRegistrationDTO userDTO) {
        Optional<User> existingUser = userRepository.findById(userId);
        if (!existingUser.isPresent()) {
            throw new RuntimeException("User not found");
        }

        User user = existingUser.get();
        user.setNombre(userDTO.getNombre());
        user.setCorreoElectronico(userDTO.getCorreoElectronico());
        user.setApodo(userDTO.getApodo());
        user.setGustoMusical(userDTO.getGustoMusical());
        user.setEstiloVestir(userDTO.getEstiloVestir());

        return userRepository.save(user);
    }

    
    
    public User updatePassword(Long userId, String currentPassword, String newPassword) {
        Optional<User> existingUser = userRepository.findById(userId);
        if (!existingUser.isPresent()) {
            throw new RuntimeException("User not found");
        }

        User user = existingUser.get();

        
        if (!passwordEncoder.matches(currentPassword, user.getContrasena())) {
            throw new RuntimeException("Current password is incorrect");
        }

        
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setContrasena(encodedPassword);

        return userRepository.save(user);
    }


    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
