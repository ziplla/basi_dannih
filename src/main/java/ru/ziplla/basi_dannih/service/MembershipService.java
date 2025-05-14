package ru.ziplla.basi_dannih.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ziplla.basi_dannih.entity.Membership;
import ru.ziplla.basi_dannih.repository.MembershipRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MembershipService {

    @Autowired
    private MembershipRepository repository;

    public List<Membership> findAll() {
        return repository.findAll();
    }

    public Optional<Membership> findById(Long id) {
        return repository.findById(id);
    }

    public Membership save(Membership membership) {
        return repository.save(membership);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
