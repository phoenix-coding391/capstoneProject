package com.example.capstoneproject.Users;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String role; // Specifies whether the user is a Customer, Admin, or Agent

    public User() {}

    public User(int id, String role) {
        this.id = id;
        this.role = role;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Role: " + role;
    }
}



