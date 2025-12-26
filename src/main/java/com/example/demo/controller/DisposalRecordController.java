package com.example.demo.controller;

import com.example.demo.entity.DisposalRecord;
import com.example.demo.service.DisposalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/disposals")
public class DisposalRecordController {

    @Autowired
    private DisposalRecordService service;

    @PostMapping("/{assetId}")
    public DisposalRecord createDisposal(@PathVariable Long assetId, @RequestBody DisposalRecord dr) {
        return service.createDisposal(assetId, dr);
    }

    @GetMapping("/{id}")
    public DisposalRecord getDisposal(@PathVariable Long id) {
        return service.getDisposal(id);
    }
}
