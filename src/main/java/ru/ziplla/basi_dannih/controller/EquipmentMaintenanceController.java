package ru.ziplla.basi_dannih.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ziplla.basi_dannih.entity.EquipmentMaintenance;
import ru.ziplla.basi_dannih.service.EquipmentMaintenanceService;

import java.util.List;

@RestController
@RequestMapping("/api/equipment-maintenance")
@RequiredArgsConstructor
public class EquipmentMaintenanceController {

    @Autowired
    private EquipmentMaintenanceService service;

    @GetMapping
    public List<EquipmentMaintenance> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipmentMaintenance> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public EquipmentMaintenance create(@RequestBody EquipmentMaintenance maintenance) {
        return service.save(maintenance);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<EquipmentMaintenance> update(@PathVariable Long id, @RequestBody EquipmentMaintenance updatedMaintenance) {
//        return service.findById(id)
//                .map(existing -> {
//                    updatedMaintenance.setMaintenanceid(id);
//                    return ResponseEntity.ok(service.save(updatedMaintenance));
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
