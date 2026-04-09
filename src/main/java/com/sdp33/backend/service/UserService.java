package com.sdp33.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdp33.backend.model.User;
import com.sdp33.backend.repository.UserRepository;

import java.util.List;
import java.time.LocalDateTime; // <-- for timestamps

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User update(Long id, User updated) {
        User u = repo.findById(id).orElseThrow();

        u.setUsername(updated.getUsername());
        u.setEmail(updated.getEmail());

        return repo.save(u);
    }

    public void deleteUser(Long id) {
        repo.deleteById(id);
    }

    // 🔹 New helper: find user by username
    public User findByUsername(String username) {
        return repo.findByUsername(username);
    }

    // 🔹 New helper: find user by ID
    public User findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    // 🔹 New: update login timestamp
    public User updateLogin(String username) {
        User u = repo.findByUsername(username);
        if (u != null) {
            u.setLastLogin(LocalDateTime.now());
            return repo.save(u);
        }
        return null;
    }

    // 🔹 New: update logout timestamp
    public User updateLogout(Long id) {
        User u = repo.findById(id).orElse(null);
        if (u != null) {
            u.setLastLogout(LocalDateTime.now());
            return repo.save(u);
        }
        return null;
    }
}