package ru.ziplla.basi_dannih.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ziplla.basi_dannih.entity.Schedule;
import ru.ziplla.basi_dannih.repository.ScheduleRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    @Autowired
    private ScheduleRepository repository;

    public List<Schedule> findAll() {
        return repository.findAll();
    }

    public Optional<Schedule> findById(Long id) {
        return repository.findById(id);
    }

    public Schedule save(Schedule schedule) {
        return repository.save(schedule);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
