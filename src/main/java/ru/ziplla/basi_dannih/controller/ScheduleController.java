package ru.ziplla.basi_dannih.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ziplla.basi_dannih.entity.Schedule;
import ru.ziplla.basi_dannih.service.ScheduleService;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    @Autowired
    private ScheduleService service;

    @GetMapping
    public List<Schedule> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Schedule create(@RequestBody Schedule schedule) {
        return service.save(schedule);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Schedule> update(@PathVariable Long id, @RequestBody Schedule updatedSchedule) {
//        return service.findById(id)
//                .map(existing -> {
//                    updatedSchedule.setScheduleid(id);
//                    return ResponseEntity.ok(service.save(updatedSchedule));
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
