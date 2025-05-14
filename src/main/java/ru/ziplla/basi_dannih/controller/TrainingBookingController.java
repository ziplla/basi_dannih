package ru.ziplla.basi_dannih.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ziplla.basi_dannih.entity.TrainingBooking;
import ru.ziplla.basi_dannih.service.TrainingBookingService;

import java.util.List;

@RestController
@RequestMapping("/api/training-bookings")
@RequiredArgsConstructor
public class TrainingBookingController {

    @Autowired
    private TrainingBookingService service;

    @GetMapping
    public List<TrainingBooking> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainingBooking> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TrainingBooking create(@RequestBody TrainingBooking booking) {
        return service.save(booking);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrainingBooking> update(@PathVariable Long id, @RequestBody TrainingBooking updatedBooking) {
        return service.findById(id)
                .map(existing -> {
                    updatedBooking.setBookingid(id);
                    return ResponseEntity.ok(service.save(updatedBooking));
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
