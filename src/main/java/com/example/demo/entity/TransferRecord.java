package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class TransferRecord {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Asset asset;

    private String fromDepartment;
    private String toDepartment;
    private LocalDate transferDate;

    @ManyToOne
    private User approvedBy;

    public TransferRecord() {}

    public TransferRecord(Long id, Asset asset, String fromDepartment,
                          String toDepartment, LocalDate transferDate, User approvedBy) {
        this.id = id;
        this.asset = asset;
        this.fromDepartment = fromDepartment;
        this.toDepartment = toDepartment;
        this.transferDate = transferDate;
        this.approvedBy = approvedBy;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public void setFromDepartment(String d) { this.fromDepartment = d; }
    public void setToDepartment(String d) { this.toDepartment = d; }
    public void setTransferDate(LocalDate d) { this.transferDate = d; }
    public void setApprovedBy(User u) { this.approvedBy = u; }
    public String getFromDepartment() { return fromDepartment; }
    public String getToDepartment() { return toDepartment; }
}
