package com.example.demo.entity;


import jakarta.persistence.*;


@Entity
public class Asset {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String assetTag;
private String assetType;
private String status;


public Long getId() { return id; }
public void setId(Long id) { this.id = id; }
public String getAssetTag() { return assetTag; }
public void setAssetTag(String assetTag) { this.assetTag = assetTag; }
public String getAssetType() { return assetType; }
public void setAssetType(String assetType) { this.assetType = assetType; }
public String getStatus() { return status; }
public void setStatus(String status) { this.status = status; }
}