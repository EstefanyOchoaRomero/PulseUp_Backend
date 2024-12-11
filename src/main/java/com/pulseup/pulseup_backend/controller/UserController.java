// package com.pulseup.pulseup_backend.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import com.pulseup.pulseup_backend.dto.UserRegistrationDTO;
// import com.pulseup.pulseup_backend.models.User;
// import com.pulseup.pulseup_backend.service.UserService;



// @RestController
// @RequestMapping("/api/users")
// public class UserController {

//     @Autowired
//     private UserService userService;

    
//     @GetMapping("/{userId}")
//     public ResponseEntity<?> getUserData(@PathVariable Long userId) {
//         try {
//             User user = userService.getUserById(userId);
//             return ResponseEntity.ok(user);
//         } catch (Exception e) {
//             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
//         }
//     }

    
//     @PutMapping("/{userId}")
//     public ResponseEntity<?> updateUser(@PathVariable Long userId, @RequestBody UserRegistrationDTO userDTO) {
//         try {
//             User updatedUser = userService.updateUser(userId, userDTO);
//             return ResponseEntity.ok(updatedUser);
//         } catch (Exception e) {
//             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//         }
//     }

    
//     @PutMapping("/{userId}/password")
//     public ResponseEntity<?> updatePassword(@PathVariable Long userId, @RequestParam String currentPassword, @RequestParam String newPassword) {
//         try {
//             User updatedUser = userService.updatePassword(userId, currentPassword, newPassword);
//             return ResponseEntity.ok(updatedUser);
//         } catch (Exception e) {
//             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//         }
//     }

    
//     @DeleteMapping("/{userId}")
//     public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
//         try {
//             userService.deleteUser(userId);
//             return ResponseEntity.ok("User deleted successfully");
//         } catch (Exception e) {
//             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//         }
//     }
// }
