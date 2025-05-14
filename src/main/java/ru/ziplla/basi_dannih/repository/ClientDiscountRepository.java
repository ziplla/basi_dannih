package ru.ziplla.basi_dannih.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ziplla.basi_dannih.entity.ClientDiscount;

public interface ClientDiscountRepository extends JpaRepository<ClientDiscount, Long> {
}
