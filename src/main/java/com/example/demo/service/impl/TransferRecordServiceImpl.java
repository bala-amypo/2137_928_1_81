package com.example.demo.service.impl;

import com.example.demo.entity.Asset;
import com.example.demo.entity.TransferRecord;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.TransferRecordRepository;
import com.example.demo.service.TransferRecordService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransferRecordServiceImpl implements TransferRecordService {

    private final TransferRecordRepository repo;
    private final AssetRepository assetRepo;

    public TransferRecordServiceImpl(TransferRecordRepository repo,
                                     AssetRepository assetRepo) {
        this.repo = repo;
        this.assetRepo = assetRepo;
    }

    @Override
    public TransferRecord createTransfer(Long assetId, TransferRecord record) {

        Asset asset = assetRepo.findById(assetId).orElseThrow();

        if (record.getTransferDate().isAfter(LocalDate.now())) {
            throw new ValidationException("Transfer date cannot be in the future");
        }

        record.setId(null);
        return repo.save(record);
    }

    @Override
    public List<TransferRecord> getTransfersForAsset(Long assetId) {
        return repo.findByAsset_Id(assetId);
    }
}
