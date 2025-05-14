package ru.ziplla.basi_dannih.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "client_discounts")
@Data
@RequiredArgsConstructor
public class ClientDiscount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_discount_id")
    private Long clientDiscountId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientid", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discountid", nullable = false)
    private Discount discount;

    @Column(name = "assigned_date")
    private LocalDateTime assignedDate;
}
