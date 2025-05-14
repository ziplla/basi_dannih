package ru.ziplla.basi_dannih.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ziplla.basi_dannih.entity.ClassRegistration;
import ru.ziplla.basi_dannih.service.ClassRegistrationService;

import java.util.List;

@RestController
@RequestMapping("/api/class-registrations")
@RequiredArgsConstructor
public class ClassRegistrationController {

    @Autowired
    private ClassRegistrationService service;

    @GetMapping
    public List<ClassRegistration> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassRegistration> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ClassRegistration create(@RequestBody ClassRegistration registration) {
        return service.save(registration);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<ClassRegistration> update(@PathVariable Long id, @RequestBody ClassRegistration updated) {
//        return service.findById(id)
//                .map(existing -> {
//                    updated.setRegistrationId(id);
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
