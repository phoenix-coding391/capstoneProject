package com.example.capstoneproject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.capstoneproject.DataAccess.AdminRepository;
import com.example.capstoneproject.DataAccess.UserRepository;
import com.example.capstoneproject.Users.Admin;

import java.util.List;

import static com.example.capstoneproject.Controllers.RESTNouns.*;

@RestController
@RequestMapping(VERSION_1 + ADMINS)
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @GetMapping(ID)
    public Admin getAdminById(@PathVariable int id) {
        return adminRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Admin not found with ID: " + id));
    }

    @PostMapping
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminRepository.saveWithUser(admin, userRepository);
    }

    @PutMapping(ID)
    public Admin updateAdmin(@PathVariable int id, @RequestBody Admin updatedAdmin) {
        Admin existingAdmin = adminRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Admin not found with ID: " + id));
        existingAdmin.setName(updatedAdmin.getName());
        existingAdmin.setEmail(updatedAdmin.getEmail());
        existingAdmin.setPassword(updatedAdmin.getPassword());
        return adminRepository.save(existingAdmin);
    }

    @DeleteMapping(ID)
    public void deleteAdmin(@PathVariable int id) {
        adminRepository.deleteById(id);
    }
}
