package ru.ziplla.basi_dannih.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ziplla.basi_dannih.entity.Inventory;
import ru.ziplla.basi_dannih.service.InventoryService;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    @Autowired
    private InventoryService service;

    @GetMapping
    public List<Inventory> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventory> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Inventory create(@RequestBody Inventory inventory) {
        return service.save(inventory);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Inventory> update(@PathVariable Long id, @RequestBody Inventory updatedInventory) {
//        return service.findById(id)
//                .map(existing -> {
//                    updatedInventory.setInventoryid(id);
//                    return ResponseEntity.ok(service.save(updatedInventory));
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
