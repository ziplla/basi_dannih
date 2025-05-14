package ru.ziplla.basi_dannih.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ziplla.basi_dannih.entity.Attendance;
import ru.ziplla.basi_dannih.service.AttendanceService;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
@RequiredArgsConstructor
public class AttendanceController {

    @Autowired
    private AttendanceService service;

    @GetMapping
    public List<Attendance> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attendance> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Attendance create(@RequestBody Attendance attendance) {
        return service.save(attendance);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Attendance> update(@PathVariable Long id, @RequestBody Attendance updated) {
//        return service.findById(id)
//                .map(existing -> {
//                    updated.setAttendanceId(id);
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
