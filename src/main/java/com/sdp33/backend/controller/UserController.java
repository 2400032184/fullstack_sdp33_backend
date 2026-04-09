package com.sdp33.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sdp33.backend.model.User;
import com.sdp33.backend.service.UserService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService service;

    // ✅ GET all users
    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    // ✅ UPDATE user
    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        return service.update(id, user);
    }

    // ✅ DELETE user
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return "User deleted successfully";
    }

    // 🔹 LOGIN endpoint to update lastLogin
    @PostMapping("/login")
    public User updateLogin(@RequestParam String username) {
        User user = service.findByUsername(username);
        if (user != null) {
            user.setLastLogin(LocalDateTime.now());
            return service.update(user.getId(), user);
        }
        return null; // Or throw exception if preferred
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