package ru.ziplla.basi_dannih.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ziplla.basi_dannih.entity.FinancialTransaction;

public interface FinancialTransactionRepository extends JpaRepository<FinancialTransaction, Long> {
}
