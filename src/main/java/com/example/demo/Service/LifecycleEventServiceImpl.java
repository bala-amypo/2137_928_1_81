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


public LifecycleEvent save(LifecycleEvent event) {
return repository.save(event);
}


public List<LifecycleEvent> getAll() {
return repository.findAll();
}


public LifecycleEvent getById(Long id) {
return repository.findById(id).orElse(null);
}


public LifecycleEvent update(Long id, LifecycleEvent event) {
LifecycleEvent existing = getById(id);
if (existing != null) {
existing.setAssetTag(event.getAssetTag());
existing.setEventType(event.getEventType());
existing.setDescription(event.getDescription());
existing.setEventTime(event.getEventTime());
}