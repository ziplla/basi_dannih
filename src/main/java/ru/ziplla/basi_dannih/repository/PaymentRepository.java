package ru.ziplla.basi_dannih.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ziplla.basi_dannih.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
