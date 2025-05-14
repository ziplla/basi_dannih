package ru.ziplla.basi_dannih.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ziplla.basi_dannih.entity.Staff;
import ru.ziplla.basi_dannih.repository.StaffRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StaffService {

    @Autowired
    private StaffRepository repository;

    public List<Staff> findAll() {
        return repository.findAll();
    }

    public Optional<Staff> findById(Long id) {
        return repository.findById(id);
    }

    public Staff save(Staff staff) {
        return repository.save(staff);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
