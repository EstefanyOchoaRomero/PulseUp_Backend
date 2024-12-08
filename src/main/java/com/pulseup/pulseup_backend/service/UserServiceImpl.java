package com.pulseup.pulseup_backend.service;




import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pulseup.pulseup_backend.dto.UserLoginDTO;
import com.pulseup.pulseup_backend.dto.UserRegistrationDTO;
import com.pulseup.pulseup_backend.models.User;
import com.pulseup.pulseup_backend.repository.UserRepository;



@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User userRegistration(UserRegistrationDTO userDTO) {

        User user = new User();
        user.setNombre(userRegistrationDTO.getNombre());
        user.setApellido(userDTO.getApellido());
        user.setApodo(userDTO.getApodo());
        user.setGustoMusical(userDTO.getGustoMusical());
        user.setEstiloVestir(userDTO.getEstiloVestir());
        user.setCorreoElectronico(userDTO.getCorreoElectronico());
        user.setContrasena(userDTO.getContrasena());

        return userRepository.save(user);
    }


    





    @Override
    public User authenticateUser(UserLoginDTO userDTO) {
        Optional<User> usuario = userRepository.findByCorreoElectronico(userDTO.getCorreoElectronico());
        if (usuario.isPresent() && passwordEncoder.matches(userDTO.getContrasena(), usuario.get().getContrasena())) {
            return usuario.get();
        }
        throw new RuntimeException("Invalid credentials");
    }
}