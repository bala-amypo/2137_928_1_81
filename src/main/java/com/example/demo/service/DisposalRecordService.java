package com.example.demo.service;


import java.util.List;
import com.example.demo.entity.DisposalRecord;


public interface DisposalRecordService {
DisposalRecord save(DisposalRecord record);
List<DisposalRecord> getAll();
DisposalRecord getById(Long id);
DisposalRecord update(Long id, DisposalRecord record);
void delete(Long id);
}