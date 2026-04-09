package com.sdp33.backend.service;

import com.sdp33.backend.model.User;
import com.sdp33.backend.model.Admin;
import com.sdp33.backend.payload.SignupRequest;
import com.sdp33.backend.payload.LoginRequest;
import com.sdp33.backend.payload.ApiResponse;
import com.sdp33.backend.repository.UserRepository;
import com.sdp33.backend.repository.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;

    // ================= SIGNUP =================
    public ApiResponse register(SignupRequest request) {

        String role = request.getRole() != null ? request.getRole().toUpperCase() : "USER";

        // ===== ADMIN SIGNUP =====
        if (role.equals("ADMIN")) {

            if (adminRepository.existsByUsername(request.getUsername())) {
                return new ApiResponse(false, "Admin already exists");
            }

            Admin admin = new Admin();
            admin.setUsername(request.getUsername().trim());
            admin.setEmail(request.getEmail().trim());
            admin.setPassword(request.getPassword().trim());
            admin.setRole("ADMIN");

            adminRepository.save(admin);

            return new ApiResponse(true, "Admin registered successfully", admin);
        }

        // ===== USER SIGNUP =====
        if (userRepository.existsByUsername(request.getUsername())) {
            return new ApiResponse(false, "Username already exists");
        }

        User user = new User();
        user.setUsername(request.getUsername().trim());
        user.setEmail(request.getEmail().trim());
        user.setPassword(request.getPassword().trim());

        userRepository.save(user);

        return new ApiResponse(true, "User registered successfully", user);
    }

    // ================= LOGIN =================
    public ApiResponse login(LoginRequest request) {

        String username = request.getUsername().trim();
        String password = request.getPassword().trim();

        // ===== ADMIN LOGIN =====
        Admin admin = adminRepository.findByUsername(username);
        if (admin != null && admin.getPassword().equals(password)) {
            return new ApiResponse(true, "Admin login successful", admin); // ✅ full admin returned
        }

        // ===== USER LOGIN =====
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return new ApiResponse(true, "User login successful", user); // ✅ full user returned
        }

        return new ApiResponse(false, "Invalid credentials");
    }
}