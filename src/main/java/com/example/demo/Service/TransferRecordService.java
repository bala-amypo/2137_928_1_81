package com.example.demo.service;


import java.util.List;
import com.example.demo.entity.TransferRecord;


public interface TransferRecordService {
TransferRecord save(TransferRecord record);
List<TransferRecord> getAll();
TransferRecord getById(Long id);
TransferRecord update(Long id, TransferRecord record);
void delete(Long id);
}