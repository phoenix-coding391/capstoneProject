package com.example.capstoneproject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.capstoneproject.DataAccess.AgentRepository;
import com.example.capstoneproject.Users.Agent;

import java.util.List;

import static com.example.capstoneproject.Controllers.RESTNouns.*;

@RestController
@RequestMapping(VERSION_1 + AGENTS)
public class AgentController {
    @Autowired
    private AgentRepository agentRepository;

    @GetMapping
    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

    @GetMapping(ID)
    public Agent getAgentById(@PathVariable int id) {
        return agentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Agent not found with ID: " + id));
    }

    @PostMapping
    public Agent createAgent(@RequestBody Agent agent) {
        return agentRepository.save(agent);
    }

    @PutMapping(ID)
    public Agent updateAgent(@PathVariable int id, @RequestBody Agent updatedAgent) {
        Agent existingAgent = agentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Agent not found with ID: " + id));
        existingAgent.setName(updatedAgent.getName());
        existingAgent.setEmail(updatedAgent.getEmail());
        existingAgent.setRole(updatedAgent.getRole());
        return agentRepository.save(existingAgent);
    }

    @DeleteMapping(ID)
    public void deleteAgent(@PathVariable int id) {
        agentRepository.deleteById(id);
    }
}
