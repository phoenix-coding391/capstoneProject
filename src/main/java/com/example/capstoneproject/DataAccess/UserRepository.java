package com.example.capstoneproject.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.capstoneproject.Users.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
