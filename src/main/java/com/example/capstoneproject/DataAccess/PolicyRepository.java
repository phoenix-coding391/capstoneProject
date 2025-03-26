package com.example.capstoneproject.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.capstoneproject.Policy.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Integer> {
}
