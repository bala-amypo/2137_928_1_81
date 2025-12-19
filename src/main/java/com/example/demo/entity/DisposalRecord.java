package com.example.demo.entity;


import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
public class DisposalRecord {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String assetTag;
private String method;
private LocalDate disposalDate;


public Long getId() { return id; }
public void setId(Long id) { this.id = id; }
public String getAssetTag() { return assetTag; }
public void setAssetTag(String assetTag) { this.assetTag = assetTag; }
public String getMethod() { return method; }
public void setMethod(String method) { this.method = method; }
public LocalDate getDisposalDate() { return disposalDate; }
public void setDisposalDate(LocalDate disposalDate) { this.disposalDate = disposalDate; }
}