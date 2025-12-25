package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
@Transactional   // ✅ enables transactions for all service methods
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public User update(Long id, User user) {
        User existing = getById(id);
        if (existing != null) {
            existing.setName(user.getName());
            existing.setEmail(user.getEmail());
            return repository.save(existing);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
