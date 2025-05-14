package ru.ziplla.basi_dannih.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ziplla.basi_dannih.entity.ClassEntity;

public interface ClassRepository extends JpaRepository<ClassEntity, Long> {
}
