package ru.ziplla.basi_dannih.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "financialtransactions")
@Data
@RequiredArgsConstructor
public class FinancialTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transactionid")
    private Long transactionid;

    @ManyToOne
    @JoinColumn(name = "clientid")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "staffid")
    private Staff staff;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "transactiondate")
    private LocalDateTime transactiondate;

    @Column(name = "transactiontype")
    private String transactiontype;
}
