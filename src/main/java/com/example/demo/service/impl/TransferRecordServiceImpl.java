package com.example.demo.service.impl;

import com.example.demo.entity.Asset;
import com.example.demo.entity.TransferRecord;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.TransferRecordRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.TransferRecordService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class TransferRecordServiceImpl implements TransferRecordService {

    private final TransferRecordRepository repository;
    private final AssetRepository assetRepository;
    private final UserRepository userRepository;

    public TransferRecordServiceImpl(TransferRecordRepository repository, AssetRepository assetRepository, UserRepository userRepository) {
        this.repository = repository; this.assetRepository = assetRepository; this.userRepository = userRepository;
    }

    @Override
    public TransferRecord createTransfer(Long assetId, TransferRecord tr) {
        Asset asset = assetRepository.findById(assetId).orElseThrow(() -> new ResourceNotFoundException("Asset not found"));
        if(tr.getTransferDate().isAfter(LocalDate.now())) throw new ValidationException("Transfer date cannot be in the future");
        User approver = userRepository.findById(tr.getApprovedBy().getId()).orElseThrow(() -> new ResourceNotFoundException("Approver not found"));
        tr.setAsset(asset); tr.setApprovedBy(approver);
        asset.setStatus("TRANSFERRED"); assetRepository.save(asset);
        return repository.save(tr);
    }

    @Override
    public List<TransferRecord> getTransfersForAsset(Long assetId) {
        return repository.findByAsset_Id(assetId);
    }
}
