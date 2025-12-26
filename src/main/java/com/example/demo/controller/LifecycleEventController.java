package com.example.demo.controller;

import com.example.demo.entity.LifecycleEvent;
import com.example.demo.service.LifecycleEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class LifecycleEventController {

    @Autowired
    private LifecycleEventService service;

    @PostMapping("/asset/{assetId}/user/{userId}")
    public LifecycleEvent logEvent(@PathVariable Long assetId, @PathVariable Long userId, @RequestBody LifecycleEvent event) {
        return service.logEvent(assetId, userId, event);
    }

    @GetMapping("/asset/{assetId}")
    public List<LifecycleEvent> getEvents(@PathVariable Long assetId) {
        return service.getEventsForAsset(assetId);
    }
}
