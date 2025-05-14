package ru.ziplla.basi_dannih.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ziplla.basi_dannih.entity.TrainingBooking;
import ru.ziplla.basi_dannih.repository.TrainingBookingRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TrainingBookingService {

    @Autowired
    private TrainingBookingRepository repository;

    public List<TrainingBooking> findAll() {
        return repository.findAll();
    }

    public Optional<TrainingBooking> findById(Long id) {
        return repository.findById(id);
    }

    public TrainingBooking save(TrainingBooking booking) {
        return repository.save(booking);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
