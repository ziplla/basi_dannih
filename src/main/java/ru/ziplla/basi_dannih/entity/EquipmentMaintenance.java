package ru.ziplla.basi_dannih.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "equipment_maintenance")
@Data
@RequiredArgsConstructor
public class EquipmentMaintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maintenanceid")
    private Long maintenanceid;

    @ManyToOne
    @JoinColumn(name = "inventoryid")
    private Inventory inventory;

    @Column(name = "maintenancedate")
    private LocalDateTime maintenancedate;

    @Column(name = "description")
    private String description;

    @Column(name = "cost")
    private BigDecimal cost;

    @ManyToOne
    @JoinColumn(name = "staffid")
    private Staff staff;
}