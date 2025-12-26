package com.example.demo.service.impl;

import com.example.demo.entity.Asset;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AssetRepository;
import com.example.demo.service.AssetService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetServiceImpl implements AssetService {

    private final AssetRepository repo;

    public AssetServiceImpl(AssetRepository repo) {
        this.repo = repo;
    }

    @Override
    public Asset createAsset(Asset asset) {
        asset.prePersist();
        return repo.save(asset);
    }

    @Override
    public Asset getAsset(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found"));
    }

    @Override
    public List<Asset> getAllAssets() {
        return repo.findAll();
    }

    @Override
    public Asset updateStatus(Long assetId, String status) {
        Asset asset = getAsset(assetId);
        asset.setStatus(status);
        return repo.save(asset);
    }
}
