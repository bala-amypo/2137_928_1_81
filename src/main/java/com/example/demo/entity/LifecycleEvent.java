package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class LifecycleEvent {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Asset asset;

    private String eventType;
    private String eventDescription;
    private LocalDateTime eventDate;

    @ManyToOne
    private User performedBy;

    public LifecycleEvent() {}

    public LifecycleEvent(Long id, Asset asset, String eventType,
                          String eventDescription, LocalDateTime eventDate, User performedBy) {
        this.id = id;
        this.asset = asset;
        this.eventType = eventType;
        this.eventDescription = eventDescription;
        this.eventDate = eventDate;
        this.performedBy = performedBy;
    }

    @PrePersist
    public void prePersist() {
        if (eventDate == null) eventDate = LocalDateTime.now();
    }

    public void setId(Long id) { this.id = id; }
    public Long getId() { return id; }
    public void setAsset(Asset asset) { this.asset = asset; }
    public Asset getAsset() { return asset; }
    public void setPerformedBy(User u) { this.performedBy = u; }
    public User getPerformedBy() { return performedBy; }
}
