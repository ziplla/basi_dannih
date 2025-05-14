package ru.ziplla.basi_dannih.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ziplla.basi_dannih.entity.InventoryUsage;
import ru.ziplla.basi_dannih.service.InventoryUsageService;

import java.util.List;

@RestController
@RequestMapping("/api/inventory-usage")
@RequiredArgsConstructor
public class InventoryUsageController {

    @Autowired
    private InventoryUsageService service;

    @GetMapping
    public List<InventoryUsage> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryUsage> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public InventoryUsage create(@RequestBody InventoryUsage usage) {
        return service.save(usage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryUsage> update(@PathVariable Long id, @RequestBody InventoryUsage updatedUsage) {
        return service.findById(id)
                .map(existing -> {
                    updatedUsage.setUsageid(id);
                    return ResponseEntity.ok(service.save(updatedUsage));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.findById(id).isPresent()) {
            service.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
