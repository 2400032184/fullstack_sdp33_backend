package com.sdp33.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sdp33.backend.model.Admin;
import com.sdp33.backend.service.AdminService;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    private AdminService service;

    // ✅ GET all admins
    @GetMapping
    public List<Admin> getAllAdmins() {
        return service.getAllAdmins();
    }

    // ✅ GET admin profile by ID (for loading full profile after login)
    @GetMapping("/{id}/profile")
    public Admin getAdminProfile(@PathVariable Long id) {
        return service.findById(id);
    }

    // ✅ UPDATE admin (including profile fields)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Admin admin) {
        try {
            Admin updated = service.update(id, admin);
            if (updated == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Admin with ID " + id + " not found");
            }
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error updating admin: " + e.getMessage());
        }
    }

    // ✅ UPDATE admin profile (full profile update)
    @PutMapping("/{id}/profile")
    public ResponseEntity<?> updateAdminProfile(@PathVariable Long id, @RequestBody Admin admin) {
        try {
            Admin updated = service.update(id, admin);
            if (updated == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Admin with ID " + id + " not found");
            }
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error updating profile: " + e.getMessage());
        }
    }

    // ✅ DELETE admin
    @DeleteMapping("/{id}")
    public String deleteAdmin(@PathVariable Long id) {
        service.deleteAdmin(id);
        return "Admin deleted successfully";
    }

    // 🔹 GET admin by username
    @GetMapping("/username/{username}")
    public Admin getAdminByUsername(@PathVariable String username) {
        return service.findByUsername(username);
    }
}
