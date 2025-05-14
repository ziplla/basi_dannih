package ru.ziplla.basi_dannih.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "trainers")
@Data
@RequiredArgsConstructor
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trainerid")
    private Long trainerid;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "phonenumber")
    private String phonenumber;

    @Column(name = "email")
    private String email;
}
