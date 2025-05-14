package ru.ziplla.basi_dannih.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ziplla.basi_dannih.entity.FinancialTransaction;
import ru.ziplla.basi_dannih.repository.FinancialTransactionRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FinancialTransactionService {

    @Autowired
    private FinancialTransactionRepository repository;

    public List<FinancialTransaction> findAll() {
        return repository.findAll();
    }

    public Optional<FinancialTransaction> findById(Long id) {
        return repository.findById(id);
    }

    public FinancialTransaction save(FinancialTransaction transaction) {
        return repository.save(transaction);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
