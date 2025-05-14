package ru.ziplla.basi_dannih.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ziplla.basi_dannih.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
