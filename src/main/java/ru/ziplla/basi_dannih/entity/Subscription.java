package ru.ziplla.basi_dannih.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "subscriptions")
@Data
@RequiredArgsConstructor
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscriptionid")
    private Long subscriptionid;

    @ManyToOne
    @JoinColumn(name = "clientid", nullable = false)
    private Client client;

    @Column(name = "startdate")
    private LocalDate startdate;

    @Column(name = "enddate")
    private LocalDate enddate;

    @Column(name = "subscriptiontype")
    private String subscriptiontype;

    @Column(name = "status")
    private String status;
}
