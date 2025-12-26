package com.example.demo.service.impl;

import com.example.demo.entity.Asset;
import com.example.demo.entity.DisposalRecord;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.DisposalRecordRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.DisposalRecordService;
import org.springframework.stereotype.Service;

@Service
public class DisposalRecordServiceImpl implements DisposalRecordService {

    private final DisposalRecordRepository repository;
    private final AssetRepository assetRepository;
    private final UserRepository userRepository;

    public DisposalRecordServiceImpl(DisposalRecordRepository repository, AssetRepository assetRepository, UserRepository userRepository) {
        this.repository = repository; this.assetRepository = assetRepository; this.userRepository = userRepository;
    }

    @Override
    public DisposalRecord createDisposal(Long assetId, DisposalRecord dr) {
        Asset asset = assetRepository.findById(assetId).orElseThrow(() -> new ResourceNotFoundException("Asset not found"));
        User approver = userRepository.findById(dr.getApprovedBy().getId()).orElseThrow(() -> new ResourceNotFoundException("Approver not found"));
        dr.setAsset(asset); dr.setApprovedBy(approver);
        asset.setStatus("DISPOSED"); assetRepository.save(asset);
        return repository.save(dr);
    }

    @Override
    public DisposalRecord getDisposal(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Disposal record not found"));
    }
}
