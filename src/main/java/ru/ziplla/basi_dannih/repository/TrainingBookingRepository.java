package ru.ziplla.basi_dannih.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ziplla.basi_dannih.entity.TrainingBooking;

public interface TrainingBookingRepository extends JpaRepository<TrainingBooking, Long> {
}
