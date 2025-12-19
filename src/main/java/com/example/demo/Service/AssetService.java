package com.example.demo.service;


import java.util.List;
import com.example.demo.entity.Asset;


public interface AssetService {
Asset save(Asset asset);
List<Asset> getAll();
Asset getById(Long id);
Asset update(Long id, Asset asset);
void delete(Long id);
}