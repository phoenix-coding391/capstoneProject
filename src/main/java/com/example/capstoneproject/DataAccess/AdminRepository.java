package com.example.capstoneproject.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.capstoneproject.Users.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
