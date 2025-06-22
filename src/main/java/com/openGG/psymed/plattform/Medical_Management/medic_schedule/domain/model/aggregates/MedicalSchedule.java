package com.openGG.psymed.plattform.Medical_Management.medic_schedule.domain.model.aggregates;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Entity
public class MedicalSchedule {

    @Id
    private UUID id;
    private String background;
    private String consultationReason;
    private LocalDate consultationDate;

    protected MedicalSchedule() {}

    public MedicalSchedule(UUID id, String background, String consultationReason, LocalDate consultationDate) {
        this.id = id;
        this.background = background;
        this.consultationReason = consultationReason;
        this.consultationDate = consultationDate;
    }

}
