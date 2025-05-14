package ru.ziplla.basi_dannih.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ziplla.basi_dannih.entity.Discount;
import ru.ziplla.basi_dannih.service.DiscountService;

import java.util.List;

@RestController
@RequestMapping("/api/discounts")
@RequiredArgsConstructor
public class DiscountController {

    @Autowired
    private DiscountService service;

    @GetMapping
    public List<Discount> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Discount> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Discount create(@RequestBody Discount discount) {
        return service.save(discount);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Discount> update(@PathVariable Long id, @RequestBody Discount updated) {
//        return service.findById(id)
//                .map(existing -> {
//                    updated.setDiscountId(id);
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
