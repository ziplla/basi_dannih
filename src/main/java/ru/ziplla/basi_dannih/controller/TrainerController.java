package ru.ziplla.basi_dannih.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ziplla.basi_dannih.entity.Trainer;
import ru.ziplla.basi_dannih.service.TrainerService;

import java.util.List;

@RestController
@RequestMapping("/api/trainers")
@RequiredArgsConstructor
public class TrainerController {

    @Autowired
    private TrainerService service;

    @GetMapping
    public List<Trainer> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trainer> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Trainer create(@RequestBody Trainer trainer) {
        return service.save(trainer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trainer> update(@PathVariable Long id, @RequestBody Trainer updatedTrainer) {
        return service.findById(id)
                .map(existing -> {
                    updatedTrainer.setTrainerid(id);
                    return ResponseEntity.ok(service.save(updatedTrainer));
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
