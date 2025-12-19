package com.example.demo.service;


import java.util.List;
import com.example.demo.entity.LifecycleEvent;


public interface LifecycleEventService {
LifecycleEvent save(LifecycleEvent event);
List<LifecycleEvent> getAll();
LifecycleEvent getById(Long id);
LifecycleEvent update(Long id, LifecycleEvent event);
void delete(Long id);
}