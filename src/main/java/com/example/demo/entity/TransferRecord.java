package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class TransferRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromDept;
    private String toDept;
    private LocalDate transferDate;

    
    @ManyToOne
    @JoinColumn(name = "asset_id")
    private Asset asset;

    
    @ManyToOne
    @JoinColumn(name = "approved_by")
    private User approvedBy;

    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFromDept() { return fromDept; }
    public void setFromDept(String fromDept) { this.fromDept = fromDept; }

    public String getToDept() { return toDept; }
    public void setToDept(String toDept) { this.toDept = toDept; }

    public LocalDate getTransferDate() { return transferDate; }
    public void setTransferDate(LocalDate transferDate) { this.transferDate = transferDate; }

    public Asset getAsset() { return asset; }
    public void setAsset(Asset asset) { this.asset = asset; }

    public User getApprovedBy() { return approvedBy; }
    public void setApprovedBy(User approvedBy) { this.approvedBy = approvedBy; }
}
