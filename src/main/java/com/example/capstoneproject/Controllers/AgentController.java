package com.example.capstoneproject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.capstoneproject.DataAccess.AgentRepository;
import com.example.capstoneproject.DataAccess.UserRepository;
import com.example.capstoneproject.Users.Agent;
import com.example.capstoneproject.Users.User;

import java.util.List;

import static com.example.capstoneproject.Controllers.RESTNouns.*;

@RestController
@RequestMapping(VERSION_1 + AGENTS)
public class AgentController {
    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private UserRepository userRepository;

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
        return agentRepository.saveWithUser(agent, userRepository);
    }

    @PutMapping(ID)
    public Agent updateAgent(@PathVariable int id, @RequestBody Agent updatedAgent) {
        Agent existingAgent = agentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Agent not found with ID: " + id));
        existingAgent.setName(updatedAgent.getName());
        existingAgent.setEmail(updatedAgent.getEmail());
        existingAgent.setPassword(updatedAgent.getPassword());
        return agentRepository.save(existingAgent);
    }

    @DeleteMapping(ID)
    public void deleteAgent(@PathVariable int id) {
        User user = userRepository.findById(getAgentById(id).getUser().getId()).orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + id));
        agentRepository.deleteById(id);
        userRepository.delete(user);
    }
}
