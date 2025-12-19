package com.example.demo.controller;


import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.DisposalRecord;
import com.example.demo.service.DisposalRecordService;


@RestController
@RequestMapping("/disposals")
public class DisposalRecordController {


private final DisposalRecordService disposalService;


public DisposalRecordController(DisposalRecordService disposalService) {
this.disposalService = disposalService;
}


@PostMapping
public DisposalRecord createDisposal(@RequestBody DisposalRecord record) {
return disposalService.save(record);
}


@GetMapping
public List<DisposalRecord> getAllDisposals() {
return disposalService.getAll();
}


@GetMapping("/{id}")
public DisposalRecord getDisposalById(@PathVariable Long id) {
return disposalService.getById(id);
}


@PutMapping("/{id}")
public DisposalRecord updateDisposal(@PathVariable Long id, @RequestBody DisposalRecord record) {
return disposalService.update(id, record);
}


@DeleteMapping("/{id}")
public String deleteDisposal(@PathVariable Long id) {
disposalService.delete(id);
return "Disposal record deleted successfully";
}
}