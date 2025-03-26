package com.example.capstoneproject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.capstoneproject.DataAccess.PolicyRepository;
import com.example.capstoneproject.Policy.Policy;

import java.util.List;

import static com.example.capstoneproject.Controllers.RESTNouns.*;

@RestController
@RequestMapping(VERSION_1 + POLICIES)
public class PolicyController {
    @Autowired
    private PolicyRepository policyRepository;

    @GetMapping
    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }

    @GetMapping(ID)
    public Policy getPolicyById(@PathVariable int id) {
        return policyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Policy not found with ID: " + id));
    }

    @PostMapping
    public Policy createPolicy(@RequestBody Policy policy) {
        return policyRepository.save(policy);
    }

    @PutMapping(ID)
    public Policy updatePolicy(@PathVariable int id, @RequestBody Policy updatedPolicy) {
        Policy existingPolicy = policyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Policy not found with ID: " + id));
        return policyRepository.save(existingPolicy);
    }

    @DeleteMapping(ID)
    public void deletePolicy(@PathVariable int id) {
        policyRepository.deleteById(id);
    }
}
