package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(User user) {

        if (user.getPassword() == null || user.getPassword().length() < 8)
            throw new ValidationException("Password must be at least 8 characters");

        if (user.getDepartment() == null || user.getDepartment().isEmpty())
            throw new ValidationException("Department is required");

        if (repository.existsByEmail(user.getEmail()))
            throw new ValidationException("Email already in use");

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER"); 
        user.setCreatedAt(LocalDateTime.now()); 

        return repository.save(user);
    }

    @Override
    public User getUser(Long id) {
        return repository.findById(id).orElseThrow();
    }
}
