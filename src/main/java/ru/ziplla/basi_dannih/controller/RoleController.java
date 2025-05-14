package ru.ziplla.basi_dannih.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ziplla.basi_dannih.entity.Role;
import ru.ziplla.basi_dannih.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleController {

    @Autowired
    private RoleService service;

    @GetMapping
    public List<Role> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Role create(@RequestBody Role role) {
        return service.save(role);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Role> update(@PathVariable Long id, @RequestBody Role updatedRole) {
//        return service.findById(id)
//                .map(existing -> {
//                    updatedRole.setRoleid(id);
//                    return ResponseEntity.ok(service.save(updatedRole));
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
