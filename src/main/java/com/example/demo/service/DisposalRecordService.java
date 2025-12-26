package com.example.demo.service;

import com.example.demo.entity.DisposalRecord;

public interface DisposalRecordService {
    DisposalRecord createDisposal(Long assetId, DisposalRecord dr);
    DisposalRecord getDisposal(Long id);
}
