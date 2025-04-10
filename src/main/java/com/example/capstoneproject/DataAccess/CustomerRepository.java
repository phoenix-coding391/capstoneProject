package com.example.capstoneproject.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import com.example.capstoneproject.Users.Customer;
import com.example.capstoneproject.Users.User;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Transactional
    default Customer saveWithUser(Customer customer, UserRepository userRepository) {
        User user = new User();
        user.setRole("Customer");
        User savedUser = userRepository.save(user);

        customer.setUser(savedUser);

        return save(customer);
    }
}
