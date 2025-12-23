package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.TransferRecord;
import com.example.demo.repository.TransferRecordRepository;
import com.example.demo.service.TransferRecordService;

@Service
@Transactional   // ✅ enables transactions for all service methods
public class TransferRecordServiceImpl implements TransferRecordService {

    private final TransferRecordRepository repository;

    public TransferRecordServiceImpl(TransferRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public TransferRecord save(TransferRecord record) {
        return repository.save(record);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TransferRecord> getAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public TransferRecord getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public TransferRecord update(Long id, TransferRecord record) {
        TransferRecord existing = getById(id);

        if (existing != null) {
            existing.setAsset(record.getAsset());
            existing.setFromDept(record.getFromDept());
            existing.setToDept(record.getToDept());
            existing.setTransferDate(record.getTransferDate());
            return repository.save(existing);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
