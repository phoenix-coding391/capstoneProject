package com.example.capstoneproject.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import com.example.capstoneproject.Users.Agent;
import com.example.capstoneproject.Users.User;

public interface AgentRepository extends JpaRepository<Agent, Integer> {
    @Transactional
    default Agent saveWithUser(Agent agent, UserRepository userRepository) {
        User user = new User();
        user.setRole("agent");
        User savedUser = userRepository.save(user);

        agent.setUser(savedUser);

        return save(agent);
    }
}
