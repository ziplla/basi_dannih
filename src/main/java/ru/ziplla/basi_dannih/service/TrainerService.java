package ru.ziplla.basi_dannih.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ziplla.basi_dannih.entity.Trainer;
import ru.ziplla.basi_dannih.repository.TrainerRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TrainerService {

    @Autowired
    private TrainerRepository repository;

    public List<Trainer> findAll() {
        return repository.findAll();
    }

    public Optional<Trainer> findById(Long id) {
        return repository.findById(id);
    }

    public Trainer save(Trainer trainer) {
        return repository.save(trainer);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
