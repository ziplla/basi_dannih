package ru.ziplla.basi_dannih.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ziplla.basi_dannih.entity.ClassRegistration;

public interface ClassRegistrationRepository extends JpaRepository<ClassRegistration, Long> {
}
