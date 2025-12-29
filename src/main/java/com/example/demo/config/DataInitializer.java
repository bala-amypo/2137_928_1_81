package com.example.demo.config;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.annotation.PostConstruct;
import java.time.LocalDateTime;

@Configuration
public class DataInitializer {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init() {
        if (userRepository.findByEmail("admin@example.com").isEmpty()) {
            User user = new User();
            user.setName("Admin");
            user.setEmail("admin@example.com");
            user.setPassword(passwordEncoder.encode("admin123"));
            user.setRole("ADMIN");
            user.setDepartment("IT");
            user.setCreatedAt(LocalDateTime.now());
            userRepository.save(user);
        }
    }
}
