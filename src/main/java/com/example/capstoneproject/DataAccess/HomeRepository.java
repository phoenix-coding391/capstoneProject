package com.example.capstoneproject.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.capstoneproject.Objects.Home;

public interface HomeRepository extends JpaRepository<Home, Integer> {
}
