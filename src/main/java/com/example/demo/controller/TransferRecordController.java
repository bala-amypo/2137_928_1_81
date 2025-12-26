package com.example.demo.controller;

import com.example.demo.entity.TransferRecord;
import com.example.demo.service.TransferRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/transfers")
public class TransferRecordController {

    @Autowired
    private TransferRecordService service;

    @PostMapping("/{assetId}")
    public TransferRecord createTransfer(@PathVariable Long assetId, @RequestBody TransferRecord tr) {
        return service.createTransfer(assetId, tr);
    }

    @GetMapping("/{assetId}")
    public List<TransferRecord> getTransfers(@PathVariable Long assetId) {
        return service.getTransfersForAsset(assetId);
    }
}
