package com.example.capstoneproject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.capstoneproject.DataAccess.VehicleRepository;
import com.example.capstoneproject.Objects.Vehicle;

import java.util.List;

import static com.example.capstoneproject.Controllers.RESTNouns.*;

@RestController
@RequestMapping(VERSION_1 + VEHICLES)
public class VehicleController {
    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @GetMapping(ID)
    public Vehicle getVehicleById(@PathVariable int id) {
        return vehicleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Vehicle not found with ID: " + id));
    }

    @PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @PutMapping(ID)
    public Vehicle updateVehicle(@PathVariable int id, @RequestBody Vehicle updatedVehicle) {
        Vehicle existingVehicle = vehicleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Vehicle not found with ID: " + id));
        existingVehicle.setMake(updatedVehicle.getMake());
        existingVehicle.setModel(updatedVehicle.getModel());
        existingVehicle.setYear(updatedVehicle.getYear());
        existingVehicle.setVin(updatedVehicle.getVin());
        return vehicleRepository.save(existingVehicle);
    }

    @DeleteMapping(ID)
    public void deleteVehicle(@PathVariable int id) {
        vehicleRepository.deleteById(id);
    }
}
