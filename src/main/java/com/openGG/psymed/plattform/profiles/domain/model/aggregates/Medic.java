package com.openGG.psymed.plattform.profiles.domain.model.aggregates;
import com.openGG.psymed.plattform.profiles.domain.model.entities.Education;
import com.openGG.psymed.plattform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Medic extends AuditableAbstractAggregateRoot<Medic> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String specialty;
    private String address;

    @Column(length = 500)
    @Size(max = 500)
    private String description = "No hay descripción";

    @ElementCollection
    @CollectionTable(name = "medic_specialties", joinColumns = @JoinColumn(name = "medic_id"))
    @Column(name = "specialty")
    private List<String> specialties = new ArrayList<>() ;

    @ElementCollection
    @CollectionTable(name = "medic_education", joinColumns = @JoinColumn(name = "medic_id"))
    private List<Education> education = new ArrayList<>() ;

    public Medic(
            String name,
            String lastName,
            String email,
            String phone,
            String specialty,
            String address
    ) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.specialty = specialty;
        this.address = address;
        this.description = "No hay descripción";
        this.specialties = new ArrayList<>();
        this.education = new ArrayList<>();
    }

    public Medic() {

    }

    public void updateDescription(String description) {
        this.description = description;
    }

    // Añadir nueva especialidad sin repetir
    public void addSpecialty(String specialty) {
        if (!this.specialties.contains(specialty)) {
            this.specialties.add(specialty);
        }
    }

    // Eliminar la especialidad
    public void removeSpecialty(String specialty) {
        this.specialties.remove(specialty);
    }

    // Añadir educación
    public void addEducation(Education educationItem) {
        this.education.add(educationItem);
    }

    // Eliminar educación
    public void removeEducation(Education educationItem) {
        this.education.remove(educationItem);
    }
}
