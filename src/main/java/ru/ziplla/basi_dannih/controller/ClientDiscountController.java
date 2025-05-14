package ru.ziplla.basi_dannih.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ziplla.basi_dannih.entity.ClientDiscount;
import ru.ziplla.basi_dannih.service.ClientDiscountService;

import java.util.List;

@RestController
@RequestMapping("/api/client-discounts")
@RequiredArgsConstructor
public class ClientDiscountController {

    @Autowired
    private ClientDiscountService service;

    @GetMapping
    public List<ClientDiscount> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDiscount> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ClientDiscount create(@RequestBody ClientDiscount clientDiscount) {
        return service.save(clientDiscount);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<ClientDiscount> update(@PathVariable Long id, @RequestBody ClientDiscount updated) {
//        return service.findById(id)
//                .map(existing -> {
//                    updated.setClientDiscountId(id);
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
