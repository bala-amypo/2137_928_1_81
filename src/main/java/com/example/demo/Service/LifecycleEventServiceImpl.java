package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.LifecycleEvent;
import com.example.demo.repository.LifecycleEventRepository;
import com.example.demo.service.LifecycleEventService;

@Service
public class LifecycleEventServiceImpl implements LifecycleEventService {

    private final LifecycleEventRepository repository;

    public LifecycleEventServiceImpl(LifecycleEventRepository repository) {
        this.repository = repository;
    }

    @Override
    public LifecycleEvent save(LifecycleEvent event) {
        return repository.save(event);
    }

    @Override
    public List<LifecycleEvent> getAll() {
        return repository.findAll();
    }

    @Override
    public LifecycleEvent getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public LifecycleEvent update(Long id, LifecycleEvent event) {
        LifecycleEvent existing = getById(id);
        if (existing != null) {
            existing.setEventType(event.getEventType());
            existing.setEventDate(event.getEventDate());
            existing.setDescription(event.getDescription());
            return repository.save(existing);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
