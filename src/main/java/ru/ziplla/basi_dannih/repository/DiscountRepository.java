package ru.ziplla.basi_dannih.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ziplla.basi_dannih.entity.Discount;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
}
