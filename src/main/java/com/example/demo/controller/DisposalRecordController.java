package com.example.demo.controller;

import com.example.demo.entity.DisposalRecord;
import com.example.demo.service.DisposalRecordService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/disposals")
public class DisposalController {

    private final DisposalRecordService service;

    public DisposalController(DisposalRecordService service) {
        this.service = service;
    }

    @PostMapping("/{assetId}")
    public DisposalRecord dispose(@PathVariable Long assetId,
                                  @RequestBody DisposalRecord record) {
        return service.createDisposal(assetId, record);
    }

    @GetMapping("/{id}")
    public DisposalRecord get(@PathVariable Long id) {
        return service.getDisposal(id);
    }
}
