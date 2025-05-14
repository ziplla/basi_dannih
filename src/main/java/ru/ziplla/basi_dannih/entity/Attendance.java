package ru.ziplla.basi_dannih.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "attendance")
@Data
@RequiredArgsConstructor
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "attendanceid")
    private Long attendanceId;

    @ManyToOne
    @JoinColumn(name = "clientid", nullable = false)
    private Client client;

    @Column(name = "checkin_time")
    private LocalDateTime checkInTime;

    @Column(name = "checkout_time")
    private LocalDateTime checkOutTime;
}
