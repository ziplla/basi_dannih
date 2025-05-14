package ru.ziplla.basi_dannih.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "schedules")
@Data
@RequiredArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scheduleid")
    private Long scheduleid;

    @ManyToOne
    @JoinColumn(name = "trainerid")
    private Trainer trainer;

    @ManyToOne
    @JoinColumn(name = "staffid")
    private Staff staff;

    @Column(name = "trainingdate")
    private LocalDateTime trainingdate;

    @Column(name = "trainingtype")
    private String trainingtype;

    @Column(name = "room")
    private String room;
}
