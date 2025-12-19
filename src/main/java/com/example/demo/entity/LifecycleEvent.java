package com.example.demo.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
public class LifecycleEvent {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String assetTag;
private String eventType;
private String description;
private LocalDateTime eventTime;


public Long getId() { return id; }
public void setId(Long id) { this.id = id; }
public String getAssetTag() { return assetTag; }
public void setAssetTag(String assetTag) { this.assetTag = assetTag; }
public String getEventType() { return eventType; }
public void setEventType(String eventType) { this.eventType = eventType; }
public String getDescription() { return description; }
public void setDescription(String description) { this.description = description; }
public LocalDateTime getEventTime() { return eventTime; }
public void setEventTime(LocalDateTime eventTime) { this.eventTime = eventTime; }
}