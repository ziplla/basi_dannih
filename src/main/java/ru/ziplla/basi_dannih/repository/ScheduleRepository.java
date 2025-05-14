package ru.ziplla.basi_dannih.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ziplla.basi_dannih.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
