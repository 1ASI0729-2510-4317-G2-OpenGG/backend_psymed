package com.openGG.psymed.plattform.Medics.medic_schedule.interfaces.rest.resources;

import java.time.LocalDate;

public record MedicalScheduleResource(
        Long patientId,
        LocalDate date,
        String status
) {}