package com.example.capstoneproject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.capstoneproject.DataAccess.UserRepository;
import com.example.capstoneproject.Users.User;

import java.util.List;

import static com.example.capstoneproject.Controllers.RESTNouns.*;

@RestController
@RequestMapping(VERSION_1 + USERS)
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(ID)
    public User getUserById(@PathVariable int id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + id));
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        user.setRole(user.getRole().toLowerCase()); // Ensure role is stored consistently
        return userRepository.save(user);
    }

    @PutMapping(ID)
    public User updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + id));
        existingUser.setRole(updatedUser.getRole().toLowerCase()); // Update role field
        return userRepository.save(existingUser);
    }

    @DeleteMapping(ID)
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }
}
