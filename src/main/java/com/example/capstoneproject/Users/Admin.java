package com.example.capstoneproject.Users;

import jakarta.persistence.Entity;

@Entity
public class Admin extends User {
    private String role;

    public Admin() {}

    public Admin(int id, String name, String email, String role) {
        super(id, name, email);
        this.role = role;
    }

    // Getters and setters
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return super.toString() + " (Admin - Role: " + role + ")";
    }
}
