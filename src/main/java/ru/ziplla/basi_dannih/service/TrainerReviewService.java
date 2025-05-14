package ru.ziplla.basi_dannih.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ziplla.basi_dannih.entity.TrainerReview;
import ru.ziplla.basi_dannih.repository.TrainerReviewRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TrainerReviewService {

    @Autowired
    private TrainerReviewRepository repository;

    public List<TrainerReview> findAll() {
        return repository.findAll();
    }

    public Optional<TrainerReview> findById(Long id) {
        return repository.findById(id);
    }

    public TrainerReview save(TrainerReview trainerReview) {
        return repository.save(trainerReview);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
