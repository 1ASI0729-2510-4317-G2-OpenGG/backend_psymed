package com.openGG.psymed.plattform.Medical_Management.medic_schedule.domain.model.aggregates;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Aggregate root representing a medical schedule entity.
 * Contains relevant information such as background, consultation reason,
 * consultation date, and the ID of the medic who owns it.
 */

@Getter
@Entity
public class MedicalSchedule {

    @Id
    private UUID id;

    private Long patientId;
    private Long medicId;
    private String background;
    private String consultationReason;
    private LocalDate consultationDate;

    protected MedicalSchedule() {}

    /**
     * Constructs a new {@code MedicalSchedule} instance with the specified parameters.
     *
     * @param id                 the unique identifier for the medical schedule
     * @param medicId            the ID of the medic who owns this schedule
     * @param background         the medical background or history of the patient
     * @param consultationReason the reason for the medical consultation
     * @param consultationDate   the date of the consultation
     */
    public MedicalSchedule(UUID id, Long medicId, Long patientId, String background, String consultationReason, LocalDate consultationDate) {
        this.id = id;
        this.medicId = medicId;
        this.patientId = patientId;
        this.background = background;
        this.consultationReason = consultationReason;
        this.consultationDate = consultationDate;
    }

}
