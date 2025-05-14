package ru.ziplla.basi_dannih.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ziplla.basi_dannih.entity.Staff;

public interface StaffRepository extends JpaRepository<Staff, Long> {
}
