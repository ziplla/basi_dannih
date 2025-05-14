package ru.ziplla.basi_dannih.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ziplla.basi_dannih.entity.ClassRegistration;
import ru.ziplla.basi_dannih.repository.ClassRegistrationRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassRegistrationService {

    @Autowired
    private ClassRegistrationRepository repository;

    public List<ClassRegistration> findAll() {
        return repository.findAll();
    }

    public Optional<ClassRegistration> findById(Long id) {
        return repository.findById(id);
    }

    public ClassRegistration save(ClassRegistration registration) {
        return repository.save(registration);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
