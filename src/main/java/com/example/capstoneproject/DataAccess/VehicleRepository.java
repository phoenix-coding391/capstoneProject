package com.example.capstoneproject.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.capstoneproject.Objects.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
}
