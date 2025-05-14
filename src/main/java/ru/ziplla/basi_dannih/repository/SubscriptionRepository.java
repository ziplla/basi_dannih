package ru.ziplla.basi_dannih.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ziplla.basi_dannih.entity.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
