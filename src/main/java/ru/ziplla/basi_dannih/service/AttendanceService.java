package ru.ziplla.basi_dannih.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ziplla.basi_dannih.entity.Attendance;
import ru.ziplla.basi_dannih.repository.AttendanceRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttendanceService {

    @Autowired
    private AttendanceRepository repository;

    public List<Attendance> findAll() {
        return repository.findAll();
    }

    public Optional<Attendance> findById(Long id) {
        return repository.findById(id);
    }

    public Attendance save(Attendance attendance) {
        return repository.save(attendance);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
