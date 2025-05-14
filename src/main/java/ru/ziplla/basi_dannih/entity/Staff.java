package ru.ziplla.basi_dannih.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "staff")
@Data
@RequiredArgsConstructor
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staffid")
    private Long staffid;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @ManyToOne
    @JoinColumn(name = "roleid")
    private Role role;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phonenumber")
    private String phonenumber;
}
