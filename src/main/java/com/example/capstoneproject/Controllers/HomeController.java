package com.example.capstoneproject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.capstoneproject.DataAccess.HomeRepository;
import com.example.capstoneproject.Objects.Home;

import java.util.List;

import static com.example.capstoneproject.Controllers.RESTNouns.*;

@RestController
@RequestMapping(VERSION_1 + HOMES)
public class HomeController {
    @Autowired
    private HomeRepository homeRepository;

    @GetMapping
    public List<Home> getAllHomes() {
        return homeRepository.findAll();
    }

    @GetMapping(ID)
    public Home getHomeById(@PathVariable int id) {
        return homeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Home not found with ID: " + id));
    }

    @PostMapping
    public Home createHome(@RequestBody Home home) {
        return homeRepository.save(home);
    }

    @PutMapping(ID)
    public Home updateHome(@PathVariable int id, @RequestBody Home updatedHome) {
        Home existingHome = homeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Home not found with ID: " + id));
        existingHome.setAddress(updatedHome.getAddress());
        existingHome.setYearBuilt(updatedHome.getYearBuilt());
        existingHome.setHomeValue(updatedHome.getHomeValue());
        return homeRepository.save(existingHome);
    }

    @DeleteMapping(ID)
    public void deleteHome(@PathVariable int id) {
        homeRepository.deleteById(id);
    }
}
