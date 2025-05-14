package ru.ziplla.basi_dannih.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ziplla.basi_dannih.entity.Subscription;
import ru.ziplla.basi_dannih.service.SubscriptionService;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    @Autowired
    private SubscriptionService service;

    @GetMapping
    public List<Subscription> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subscription> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Subscription create(@RequestBody Subscription subscription) {
        return service.save(subscription);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Subscription> update(@PathVariable Long id, @RequestBody Subscription updated) {
//        return service.findById(id)
//                .map(existing -> {
//                    updated.setSubscriptionid(id);
//                    return ResponseEntity.ok(service.save(updated));
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
