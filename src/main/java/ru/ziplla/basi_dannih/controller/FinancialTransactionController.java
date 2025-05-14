package ru.ziplla.basi_dannih.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ziplla.basi_dannih.entity.FinancialTransaction;
import ru.ziplla.basi_dannih.service.FinancialTransactionService;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class FinancialTransactionController {

    @Autowired
    private FinancialTransactionService service;

    @GetMapping
    public List<FinancialTransaction> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FinancialTransaction> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public FinancialTransaction create(@RequestBody FinancialTransaction transaction) {
        return service.save(transaction);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<FinancialTransaction> update(@PathVariable Long id, @RequestBody FinancialTransaction updatedTransaction) {
//        return service.findById(id)
//                .map(existing -> {
//                    updatedTransaction.setTransactionid(id);
//                    return ResponseEntity.ok(service.save(updatedTransaction));
//                })
//                .orElse(ResponseEntity.notFound().build());
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.findById(id).isPresent()) {
            service.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
