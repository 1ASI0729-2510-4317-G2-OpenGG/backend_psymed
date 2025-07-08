package com.openGG.psymed.plattform.Patient_Management.patient_informative_view.infrastructure.acl.external.resources;

import java.time.LocalDateTime;

public record MedicalScheduleResource(
        String id,
        Long patientId,
        String background,
        String consultationReason,
        LocalDateTime consultationDate,
        String medicId
) {}