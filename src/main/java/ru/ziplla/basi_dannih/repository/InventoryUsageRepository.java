package ru.ziplla.basi_dannih.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ziplla.basi_dannih.entity.InventoryUsage;

public interface InventoryUsageRepository extends JpaRepository<InventoryUsage, Long> {
}
