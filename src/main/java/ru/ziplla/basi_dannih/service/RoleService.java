package ru.ziplla.basi_dannih.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ziplla.basi_dannih.entity.Role;
import ru.ziplla.basi_dannih.repository.RoleRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService {

    @Autowired
    private RoleRepository repository;

    public List<Role> findAll() {
        return repository.findAll();
    }

    public Optional<Role> findById(Long id) {
        return repository.findById(id);
    }

    public Role save(Role role) {
        return repository.save(role);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
