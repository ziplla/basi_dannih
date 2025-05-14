package ru.ziplla.basi_dannih.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ziplla.basi_dannih.entity.ClientDiscount;
import ru.ziplla.basi_dannih.repository.ClientDiscountRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientDiscountService {

    @Autowired
    private ClientDiscountRepository repository;

    public List<ClientDiscount> findAll() {
        return repository.findAll();
    }

    public Optional<ClientDiscount> findById(Long id) {
        return repository.findById(id);
    }

    public ClientDiscount save(ClientDiscount clientDiscount) {
        return repository.save(clientDiscount);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
