package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.LifecycleEvent;
import com.example.demo.repository.LifecycleEventRepository;
import com.example.demo.service.LifecycleEventService;

@Service
@Transactional   // ✅ enables transactions for all methods
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
    @Transactional(readOnly = true)
    public List<LifecycleEvent> getAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public LifecycleEvent getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public LifecycleEvent update(Long id, LifecycleEvent event) {
        LifecycleEvent existing = getById(id);

        if (existing != null) {
            existing.setEventType(event.getEventType());
            existing.setDescription(event.getDescription());
            // eventDate is auto-managed (@PrePersist)
            return repository.save(existing);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
