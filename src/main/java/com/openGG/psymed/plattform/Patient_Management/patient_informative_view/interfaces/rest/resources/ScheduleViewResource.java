package com.openGG.psymed.plattform.Patient_Management.patient_informative_view.interfaces.rest.resources;

import java.time.LocalDateTime;

public record ScheduleViewResource(
        String id,
        Long patientId,
        String background,
        String consultationReason,
        LocalDateTime consultationDate,
        String medicId
) {}