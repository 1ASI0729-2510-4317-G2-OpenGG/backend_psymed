package com.openGG.psymed.plattform.Patient_Management.patient_informative_view.interfaces.rest.resources;

public record PillViewResource(
        Long id,
        String name,
        String description,
        Long patientId,
        String interval,
        String quantity
) {}