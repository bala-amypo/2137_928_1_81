package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @Override
    public User registerUser(User user) {

        if (repo.existsByEmail(user.getEmail())) {
            throw new ValidationException("Email already in use");
        }

        if (user.getPassword() == null || user.getPassword().length() < 8) {
            throw new ValidationException("Password must be at least 8 characters");
        }

        if (user.getDepartment() == null) {
            throw new ValidationException("Department is required");
        }

        user.prePersist();
        return repo.save(user);
    }

    @Override
    public User getByEmail(String email) {
        return repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
