package com.example.capstoneproject.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.capstoneproject.Users.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
