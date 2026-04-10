package com.sdp33.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdp33.backend.model.User;
import com.sdp33.backend.repository.UserRepository;

import java.util.List;
import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User update(Long id, User updated) {
        User u = repo.findById(id).orElse(null);
        if (u == null) {
            return null; // Will return 500 error, need to handle in controller
        }

        // Update basic auth fields
        if (updated.getUsername() != null) u.setUsername(updated.getUsername());
        if (updated.getEmail() != null) u.setEmail(updated.getEmail());

        // Update profile fields
        if (updated.getProfilePic() != null) u.setProfilePic(updated.getProfilePic());
        if (updated.getName() != null) u.setName(updated.getName());
        if (updated.getRegisterNumber() != null) u.setRegisterNumber(updated.getRegisterNumber());
        if (updated.getDob() != null) u.setDob(updated.getDob());
        if (updated.getAge() != null) u.setAge(updated.getAge());
        if (updated.getGender() != null) u.setGender(updated.getGender());
        if (updated.getPhone() != null) u.setPhone(updated.getPhone());
        if (updated.getAddress() != null) u.setAddress(updated.getAddress());
        if (updated.getBloodType() != null) u.setBloodType(updated.getBloodType());
        if (updated.getMaritalStatus() != null) u.setMaritalStatus(updated.getMaritalStatus());
        if (updated.getLanguages() != null) u.setLanguages(updated.getLanguages());
        if (updated.getOccupation() != null) u.setOccupation(updated.getOccupation());
        if (updated.getInstitution() != null) u.setInstitution(updated.getInstitution());
        if (updated.getAcademicYear() != null) u.setAcademicYear(updated.getAcademicYear());
        if (updated.getDepartment() != null) u.setDepartment(updated.getDepartment());

        return repo.save(u);
    }

    public void deleteUser(Long id) {
        repo.deleteById(id);
    }

    public User findByUsername(String username) {
        return repo.findByUsername(username);
    }

    public User findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public User updateLogin(String username) {
        User u = repo.findByUsername(username);
        if (u != null) {
            u.setLastLogin(LocalDateTime.now());
            return repo.save(u);
        }
        return null;
    }

    public User updateLogout(Long id) {
        User u = repo.findById(id).orElse(null);
        if (u != null) {
            u.setLastLogout(LocalDateTime.now());
            return repo.save(u);
        }
        return null;
    }
}