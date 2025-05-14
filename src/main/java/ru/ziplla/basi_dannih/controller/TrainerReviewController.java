package ru.ziplla.basi_dannih.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ziplla.basi_dannih.entity.TrainerReview;
import ru.ziplla.basi_dannih.service.TrainerReviewService;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class TrainerReviewController {

    @Autowired
    private TrainerReviewService service;

    @GetMapping
    public List<TrainerReview> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainerReview> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TrainerReview create(@RequestBody TrainerReview trainerReview) {
        return service.save(trainerReview);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<TrainerReview> update(@PathVariable Long id, @RequestBody TrainerReview updated) {
//        return service.findById(id)
//                .map(existing -> {
//                    updated.setReviewId(id);
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
