package com.example.demo.service.impl;

import com.example.demo.entity.Asset;
import com.example.demo.entity.DisposalRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.DisposalRecordRepository;
import com.example.demo.service.DisposalRecordService;
import org.springframework.stereotype.Service;

@Service
public class DisposalRecordServiceImpl implements DisposalRecordService {

    private final DisposalRecordRepository repo;
    private final AssetRepository assetRepo;

    public DisposalRecordServiceImpl(DisposalRecordRepository repo,
                                     AssetRepository assetRepo) {
        this.repo = repo;
        this.assetRepo = assetRepo;
    }

    @Override
    public DisposalRecord createDisposal(Long assetId, DisposalRecord record) {

        Asset asset = assetRepo.findById(assetId).orElseThrow();
        asset.setStatus("DISPOSED");
        assetRepo.save(asset);

        return repo.save(record);
    }

    @Override
    public DisposalRecord getDisposal(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Disposal record not found"));
    }
}
