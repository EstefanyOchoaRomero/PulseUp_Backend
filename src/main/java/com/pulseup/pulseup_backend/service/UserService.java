package com.pulseup.pulseup_backend.service;



import com.pulseup.pulseup_backend.dto.UserLoginDTO;
import com.pulseup.pulseup_backend.dto.UserRegistrationDTO;
import com.pulseup.pulseup_backend.models.User;



public interface UserService {
    
    User registerUser(UserRegistrationDTO userDTO);
    

    User authenticateUser(UserLoginDTO userDTO);
    
    
    User getUserById(Long userId);
    
    
    User updateUser(Long userId, UserRegistrationDTO userDTO);
    

    User updatePassword(Long userId, String currentPassword, String newPassword);
    
    
    void deleteUser(Long userId);
}
