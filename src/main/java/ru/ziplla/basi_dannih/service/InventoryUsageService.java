package ru.ziplla.basi_dannih.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ziplla.basi_dannih.entity.InventoryUsage;
import ru.ziplla.basi_dannih.repository.InventoryUsageRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryUsageService {

    @Autowired
    private InventoryUsageRepository repository;

    public List<InventoryUsage> findAll() {
        return repository.findAll();
    }

    public Optional<InventoryUsage> findById(Long id) {
        return repository.findById(id);
    }

    public InventoryUsage save(InventoryUsage usage) {
        return repository.save(usage);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
