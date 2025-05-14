package ru.ziplla.basi_dannih.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ziplla.basi_dannih.entity.Staff;
import ru.ziplla.basi_dannih.service.StaffService;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
@RequiredArgsConstructor
public class StaffController {

    @Autowired
    private StaffService service;

    @GetMapping
    public List<Staff> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Staff> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Staff create(@RequestBody Staff staff) {
        return service.save(staff);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Staff> update(@PathVariable Long id, @RequestBody Staff updatedStaff) {
//        return service.findById(id)
//                .map(existing -> {
//                    updatedStaff.setStaffid(id);
//                    return ResponseEntity.ok(service.save(updatedStaff));
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
