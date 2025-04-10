package com.example.capstoneproject.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import com.example.capstoneproject.Users.Admin;
import com.example.capstoneproject.Users.User;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    @Transactional
    default Admin saveWithUser(Admin admin, UserRepository userRepository) {
        User user = new User();
        user.setRole("Admin");
        User savedUser = userRepository.save(user);

        admin.setUser(savedUser);

        return save(admin);
    }
}
