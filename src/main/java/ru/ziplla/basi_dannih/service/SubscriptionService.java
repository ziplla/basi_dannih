package ru.ziplla.basi_dannih.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ziplla.basi_dannih.entity.Subscription;
import ru.ziplla.basi_dannih.repository.SubscriptionRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository repository;

    public List<Subscription> findAll() {
        return repository.findAll();
    }

    public Optional<Subscription> findById(Long id) {
        return repository.findById(id);
    }

    public Subscription save(Subscription subscription) {
        return repository.save(subscription);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
