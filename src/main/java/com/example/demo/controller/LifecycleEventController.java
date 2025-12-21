package com.example.demo.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.LifecycleEvent;
import com.example.demo.service.LifecycleEventService;


@RestController
@RequestMapping("/events")
public class LifecycleEventController {


private final LifecycleEventService lifecycleService;


public LifecycleEventController(LifecycleEventService lifecycleService) {
this.lifecycleService = lifecycleService;
}


@PostMapping
public LifecycleEvent createEvent(@Valid @RequestBody LifecycleEvent event) {
return lifecycleService.save(event);
}


@GetMapping
public List<LifecycleEvent> getAllEvents() {
return lifecycleService.getAll();
}


@GetMapping("/{id}")
public LifecycleEvent getEventById(@PathVariable Long id) {
return lifecycleService.getById(id);
}


@PutMapping("/{id}")
public LifecycleEvent updateEvent(@PathVariable Long id, @RequestBody LifecycleEvent event) {
return lifecycleService.update(id, event);
}
}