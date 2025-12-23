package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Asset;
import com.example.demo.repository.AssetRepository;
import com.example.demo.service.AssetService;

@Service
@Transactional   // ✅ enables transaction management for all methods
public class AssetServiceImpl implements AssetService {

    private final AssetRepository repository;

    public AssetServiceImpl(AssetRepository repository) {
        this.repository = repository;
    }

    public Asset save(Asset asset) {
        return repository.save(asset);
    }

    @Transactional(readOnly = true)
    public List<Asset> getAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Asset getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Asset update(Long id, Asset asset) {
        Asset existing = getById(id);
        if (existing != null) {
            existing.setAssetTag(asset.getAssetTag());
            existing.setAssetType(asset.getAssetType());
            existing.setStatus(asset.getStatus());
            return repository.save(existing);
        }
        return null;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
