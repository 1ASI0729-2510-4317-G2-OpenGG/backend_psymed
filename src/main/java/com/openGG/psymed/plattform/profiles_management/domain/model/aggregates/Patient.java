package com.openGG.psymed.plattform.profiles_management.domain.model.aggregates;
import com.openGG.psymed.plattform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Patient extends AuditableAbstractAggregateRoot<Patient> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastName;
    private String email;

    public Patient(String name, String lastName, String email) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;

    }

    public Patient() {

    }
}
