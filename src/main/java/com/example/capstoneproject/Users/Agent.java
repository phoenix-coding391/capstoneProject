package com.example.capstoneproject.Users;

import jakarta.persistence.*;

@Entity
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false) // Links to User table
    private User user;

    public Agent() {}

    public Agent(int id, String name, String email, User user) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.user = user;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Agent [ID=" + id + ", Name=" + name + ", Email=" + email + ", Role=" + user.getRole() + "]";
    }
}



