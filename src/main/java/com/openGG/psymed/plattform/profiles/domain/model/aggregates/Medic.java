package com.openGG.psymed.plattform.profiles.domain.model.aggregates;
import com.openGG.psymed.plattform.profiles.domain.model.entities.Education;
import com.openGG.psymed.plattform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;

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
    private List<String> specialties;

    @ElementCollection
    @CollectionTable(name = "medic_education", joinColumns = @JoinColumn(name = "medic_id"))
    private List<Education> education;

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
    }

    public Medic() {

    }

    public void updateDescription(String description) {
        this.description = description;
    }

    public void updateSpecialties(List<String> specialties) {
        this.specialties.clear();
        this.specialties.addAll(specialties);
    }

    public void updateEducation(List<Education> education) {
        this.education.clear();
        this.education.addAll(education);
    }

    public void addSpecialty(String specialty) {
        this.specialties.add(specialty);
    }

    public void addEducation(Education educationItem) {
        this.education.add(educationItem);
    }
}
