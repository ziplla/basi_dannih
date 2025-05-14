package ru.ziplla.basi_dannih.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "inventoryusage")
@Data
@RequiredArgsConstructor
public class InventoryUsage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usageid")
    private Long usageid;

    @ManyToOne
    @JoinColumn(name = "inventoryid")
    private Inventory inventory;

    @ManyToOne
    @JoinColumn(name = "clientid")
    private Client client;

    @Column(name = "usagedate")
    private LocalDateTime usagedate;
}
