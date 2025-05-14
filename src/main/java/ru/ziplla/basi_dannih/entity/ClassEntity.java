package ru.ziplla.basi_dannih.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "classes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classid")
    private Long classId;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "trainerid", nullable = false)
    private Trainer trainer;

    @ManyToOne
    @JoinColumn(name = "scheduleid", nullable = false)
    private Schedule schedule;

    @Column(name = "capacity")
    private Integer capacity;
}
