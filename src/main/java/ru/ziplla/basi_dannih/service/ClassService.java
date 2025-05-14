package ru.ziplla.basi_dannih.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ziplla.basi_dannih.entity.ClassEntity;
import ru.ziplla.basi_dannih.repository.ClassRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassService {

    @Autowired
    private ClassRepository repository;

    public List<ClassEntity> findAll() {
        return repository.findAll();
    }

    public Optional<ClassEntity> findById(Long id) {
        return repository.findById(id);
    }

    public ClassEntity save(ClassEntity classEntity) {
        return repository.save(classEntity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
