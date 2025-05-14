package ru.ziplla.basi_dannih.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ziplla.basi_dannih.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
