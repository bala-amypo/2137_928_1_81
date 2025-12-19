package com.example.demo.service.impl;


import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.TransferRecord;
import com.example.demo.repository.TransferRecordRepository;
import com.example.demo.service.TransferRecordService;


@Service
public class TransferRecordServiceImpl implements TransferRecordService {


private final TransferRecordRepository repository;


public TransferRecordServiceImpl(TransferRecordRepository repository) {
this.repository = repository;
}


public TransferRecord save(TransferRecord record) {
return repository.save(record);
}


public List<TransferRecord> getAll() {
return repository.findAll();
}


public TransferRecord getById(Long id) {
return repository.findById(id).orElse(null);
}


public TransferRecord update(Long id, TransferRecord record) {
TransferRecord existing = getById(id);
if (existing != null) {
existing.setAssetTag(record.getAssetTag());
existing.setFromDept(record.getFromDept());
existing.setToDept(record.getToDept());
existing.setTransferDate(record.getTransferDate());
}