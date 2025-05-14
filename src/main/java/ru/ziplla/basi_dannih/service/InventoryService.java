package ru.ziplla.basi_dannih.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ziplla.basi_dannih.entity.Inventory;
import ru.ziplla.basi_dannih.repository.InventoryRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryService {

    @Autowired
    private InventoryRepository repository;

    public List<Inventory> findAll() {
        return repository.findAll();
    }

    public Optional<Inventory> findById(Long id) {
        return repository.findById(id);
    }

    public Inventory save(Inventory inventory) {
        return repository.save(inventory);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
