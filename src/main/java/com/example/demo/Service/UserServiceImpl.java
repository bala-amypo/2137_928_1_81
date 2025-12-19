package com.example.demo.service.impl;


import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;


@Service
public class UserServiceImpl implements UserService {


private final UserRepository repository;


public UserServiceImpl(UserRepository repository) {
this.repository = repository;
}


public User save(User user) {
return repository.save(user);
}


public List<User> getAll() {
return repository.findAll();
}


public User getById(Long id) {
return repository.findById(id).orElse(null);
}


public User update(Long id, User user) {
User existing = getById(id);
if (existing != null) {
existing.setName(user.getName());
existing.setEmail(user.getEmail());
existing.setDepartment(user.getDepartment());
return repository.save(existing);
}