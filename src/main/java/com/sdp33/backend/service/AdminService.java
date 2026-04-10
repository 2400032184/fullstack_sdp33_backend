package com.sdp33.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdp33.backend.model.Admin;
import com.sdp33.backend.repository.AdminRepository;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository repo;

    public List<Admin> getAllAdmins() {
        return repo.findAll();
    }

    public Admin update(Long id, Admin updated) {
        Admin a = repo.findById(id).orElse(null);
        if (a == null) {
            return null; // Will return 500 error, need to handle in controller
        }

        // Update basic auth fields
        if (updated.getUsername() != null) a.setUsername(updated.getUsername());
        if (updated.getEmail() != null) a.setEmail(updated.getEmail());
        if (updated.getRole() != null) a.setRole(updated.getRole());

        // Update profile fields
        if (updated.getProfilePic() != null) a.setProfilePic(updated.getProfilePic());
        if (updated.getName() != null) a.setName(updated.getName());
        if (updated.getEmployeeId() != null) a.setEmployeeId(updated.getEmployeeId());
        if (updated.getDob() != null) a.setDob(updated.getDob());
        if (updated.getAge() != null) a.setAge(updated.getAge());
        if (updated.getGender() != null) a.setGender(updated.getGender());
        if (updated.getPhone() != null) a.setPhone(updated.getPhone());
        if (updated.getAddress() != null) a.setAddress(updated.getAddress());
        if (updated.getBloodType() != null) a.setBloodType(updated.getBloodType());
        if (updated.getMaritalStatus() != null) a.setMaritalStatus(updated.getMaritalStatus());
        if (updated.getDepartment() != null) a.setDepartment(updated.getDepartment());
        if (updated.getWorkplace() != null) a.setWorkplace(updated.getWorkplace());
        if (updated.getLanguages() != null) a.setLanguages(updated.getLanguages());
        if (updated.getJobPositions() != null) a.setJobPositions(updated.getJobPositions());

        return repo.save(a);
    }

    public void deleteAdmin(Long id) {
        repo.deleteById(id);
    }

    public Admin findByUsername(String username) {
        return repo.findByUsername(username);
    }

    public Admin findById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
