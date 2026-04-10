package com.sdp33.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sdp33.backend.model.User;
import com.sdp33.backend.service.UserService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    // ✅ GET all users
    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    // ✅ GET user profile by ID (for loading full profile after login)
    @GetMapping("/{id}/profile")
    public User getUserProfile(@PathVariable Long id) {
        return service.findById(id);
    }

    // ✅ UPDATE user (including profile fields)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody User user) {
        try {
            User updated = service.update(id, user);
            if (updated == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User with ID " + id + " not found");
            }
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error updating user: " + e.getMessage());
        }
    }

    // ✅ UPDATE user profile (full profile update)
    @PutMapping("/{id}/profile")
    public ResponseEntity<?> updateUserProfile(@PathVariable Long id, @RequestBody User user) {
        try {
            User updated = service.update(id, user);
            if (updated == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User with ID " + id + " not found");
            }
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error updating profile: " + e.getMessage());
        }
    }

    // ✅ DELETE user
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return "User deleted successfully";
    }

    // 🔹 LOGIN endpoint to update lastLogin and return full user
    @PostMapping("/login")
    public User updateLogin(@RequestParam String username) {
        User user = service.findByUsername(username);
        if (user != null) {
            user.setLastLogin(LocalDateTime.now());
            return service.update(user.getId(), user);
        }
        return null;
    }

    // 🔹 LOGOUT endpoint to update lastLogout
    @PostMapping("/logout")
    public User updateLogout(@RequestParam Long id) {
        User user = service.findById(id);
        if (user != null) {
            user.setLastLogout(LocalDateTime.now());
            return service.update(user.getId(), user);
        }
        return null;
    }
}