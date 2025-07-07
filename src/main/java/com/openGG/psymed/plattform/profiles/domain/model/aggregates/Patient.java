package com.openGG.psymed.plattform.profiles.domain.model.aggregates;
import com.openGG.psymed.plattform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter

@Entity
public class Patient extends AuditableAbstractAggregateRoot<Patient> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String name;
    @Setter
    private String lastName;
    @Setter
    private String dni;
    @Setter
    private String email;
    @Setter
    private String phone;
    @Setter
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    public Patient(String name, String lastName, String dni, String email, String phone, LocalDate birthDate) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
    }

    public Patient() {

    }
}
