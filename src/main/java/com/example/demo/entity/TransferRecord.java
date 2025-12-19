package com.example.demo.entity;


import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
public class TransferRecord {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String assetTag;
private String fromDept;
private String toDept;
private LocalDate transferDate;


public Long getId() { return id; }
public void setId(Long id) { this.id = id; }
public String getAssetTag() { return assetTag; }
public void setAssetTag(String assetTag) { this.assetTag = assetTag; }
public String getFromDept() { return fromDept; }
public void setFromDept(String fromDept) { this.fromDept = fromDept; }
public String getToDept() { return toDept; }
public void setToDept(String toDept) { this.toDept = toDept; }
public LocalDate getTransferDate() { return transferDate; }
public void setTransferDate(LocalDate transferDate) { this.transferDate = transferDate; }
}