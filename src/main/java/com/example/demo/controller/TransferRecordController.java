package com.example.demo.controller;


import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.TransferRecord;
import com.example.demo.service.TransferRecordService;


@RestController
@RequestMapping("/transfers")
public class TransferRecordController {


private final TransferRecordService transferService;


public TransferRecordController(TransferRecordService transferService) {
this.transferService = transferService;
}


@PostMapping
public TransferRecord createTransfer(@RequestBody TransferRecord record) {
return transferService.save(record);
}


@GetMapping
public List<TransferRecord> getAllTransfers() {
return transferService.getAll();
}


@GetMapping("/{id}")
public TransferRecord getTransferById(@PathVariable Long id) {
return transferService.getById(id);
}


@PutMapping("/{id}")
public TransferRecord updateTransfer(@PathVariable Long id, @RequestBody TransferRecord record) {
return transferService.update(id, record);
}


@DeleteMapping("/{id}")
public String deleteTransfer(@PathVariable Long id) {
transferService.delete(id);
return "Transfer record deleted successfully";
}
}