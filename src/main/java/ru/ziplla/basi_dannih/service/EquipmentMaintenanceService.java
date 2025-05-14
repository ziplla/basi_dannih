package ru.ziplla.basi_dannih.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ziplla.basi_dannih.entity.EquipmentMaintenance;
import ru.ziplla.basi_dannih.repository.EquipmentMaintenanceRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EquipmentMaintenanceService {

    @Autowired
    private EquipmentMaintenanceRepository repository;

    public List<EquipmentMaintenance> findAll() {
        return repository.findAll();
    }

    public Optional<EquipmentMaintenance> findById(Long id) {
        return repository.findById(id);
    }

    public EquipmentMaintenance save(EquipmentMaintenance maintenance) {
        return repository.save(maintenance);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
