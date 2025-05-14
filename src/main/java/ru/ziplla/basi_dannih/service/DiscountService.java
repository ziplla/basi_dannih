package ru.ziplla.basi_dannih.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ziplla.basi_dannih.entity.Discount;
import ru.ziplla.basi_dannih.repository.DiscountRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DiscountService {

    @Autowired
    private DiscountRepository repository;

    public List<Discount> findAll() {
        return repository.findAll();
    }

    public Optional<Discount> findById(Long id) {
        return repository.findById(id);
    }

    public Discount save(Discount discount) {
        return repository.save(discount);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
