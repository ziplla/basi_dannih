package ru.ziplla.basi_dannih.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ziplla.basi_dannih.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
