package ru.ziplla.basi_dannih.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ziplla.basi_dannih.entity.Trainer;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}
