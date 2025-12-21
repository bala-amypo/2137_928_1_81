package com.example.demo.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Asset;
import com.example.demo.service.AssetService;


@RestController
@RequestMapping("/assets")
public class AssetController {


private final AssetService assetService;


public AssetController(AssetService assetService) {
this.assetService = assetService;
}


@PostMapping
public Asset createAsset(@Valid @RequestBody Asset asset) {
return assetService.save(asset);
}


@GetMapping
public List<Asset> getAllAssets() {
return assetService.getAll();
}


@GetMapping("/{id}")
public Asset getAssetById(@PathVariable Long id) {
return assetService.getById(id);
}


@PutMapping("/{id}")
public Asset updateAsset(@PathVariable Long id, @RequestBody Asset asset) {
return assetService.update(id, asset);
}
}