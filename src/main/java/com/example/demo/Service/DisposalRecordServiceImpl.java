package com.example.demo.service.impl;


import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.DisposalRecord;
import com.example.demo.repository.DisposalRecordRepository;
import com.example.demo.service.DisposalRecordService;


@Service
public class DisposalRecordServiceImpl implements DisposalRecordService {


private final DisposalRecordRepository repository;


public DisposalRecordServiceImpl(DisposalRecordRepository repository) {
this.repository = repository;
}


public DisposalRecord save(DisposalRecord record) {
return repository.save(record);
}


public List<DisposalRecord> getAll() {
return repository.findAll();
}


public DisposalRecord getById(Long id) {
return repository.findById(id).orElse(null);
}


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


public void delete(Long id) {
repository.deleteById(id);
}
}