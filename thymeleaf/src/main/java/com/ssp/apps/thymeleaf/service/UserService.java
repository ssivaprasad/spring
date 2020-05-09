package com.ssp.apps.thymeleaf.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssp.apps.thymeleaf.entity.User;
import com.ssp.apps.thymeleaf.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(String userId) {
        return userRepository.findById(userId).map(user -> user)
                .orElseThrow(() -> new RuntimeException("No User found with id: " + userId));
    }

    public void createUser(User user) {
        userRepository.findByFirstName(user.getFirstName()).ifPresent(tempUser -> {
            throw new RuntimeException("User already Exists");
        });

        user.setId(UUID.randomUUID().toString());
        userRepository.save(user);
    }

    public void updateUser(User user) {
        userRepository.findById(user.getId())
                .orElseThrow(() -> new RuntimeException("No User found with id: " + user.getId()));
        userRepository.save(user);
    }

    public void deleteUser(String userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("No User found with id: " + userId));
        userRepository.deleteById(userId);
    }
}
