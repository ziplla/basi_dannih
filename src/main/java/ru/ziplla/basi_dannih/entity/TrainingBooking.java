package ru.ziplla.basi_dannih.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "trainingbookings")
@Data
@RequiredArgsConstructor
public class TrainingBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookingid")
    private Long bookingid;

    @ManyToOne
    @JoinColumn(name = "clientid")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "scheduleid")
    private Schedule schedule;

    @Column(name = "bookingdate")
    private LocalDateTime bookingdate;
}
