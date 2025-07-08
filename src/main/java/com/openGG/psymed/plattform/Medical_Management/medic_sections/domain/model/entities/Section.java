package com.openGG.psymed.plattform.Medical_Management.medic_sections.domain.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * Entity representing a medical section related to a patient.
 * A section may include information such as a diagnosis, therapy notes, or observations.
 */


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;
    private String type;
    private String content;
    private LocalDate createdAt;

    private Long medicId;
}