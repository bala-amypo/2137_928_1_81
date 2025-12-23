package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.DisposalRecord;
import com.example.demo.repository.DisposalRecordRepository;
import com.example.demo.service.DisposalRecordService;

@Service
@Transactional   // ✅ enables transactions for all service methods
public class DisposalRecordServiceImpl implements DisposalRecordService {

    private final DisposalRecordRepository repository;

    public DisposalRecordServiceImpl(DisposalRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public DisposalRecord save(DisposalRecord record) {
        return repository.save(record);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DisposalRecord> getAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public DisposalRecord getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public DisposalRecord update(Long id, DisposalRecord record) {
        DisposalRecord existing = getById(id);
        if (existing != null) {
            existing.setAssetTag(record.getAssetTag());
            existing.setMethod(record.getMethod());
            existing.setDisposalDate(record.getDisposalDate());
            return repository.save(existing);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
