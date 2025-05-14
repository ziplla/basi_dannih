package ru.ziplla.basi_dannih.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ziplla.basi_dannih.entity.Membership;
import ru.ziplla.basi_dannih.service.MembershipService;

import java.util.List;

@RestController
@RequestMapping("/api/memberships")
@RequiredArgsConstructor
public class MembershipController {

    @Autowired
    private MembershipService service;

    @GetMapping
    public List<Membership> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Membership> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Membership create(@RequestBody Membership membership) {
        return service.save(membership);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Membership> update(@PathVariable Long id, @RequestBody Membership updatedMembership) {
        return service.findById(id)
                .map(existing -> {
                    updatedMembership.setMembershipid(id);
                    return ResponseEntity.ok(service.save(updatedMembership));
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
