package com.openGG.psymed.plattform.Patient_Management.patient_informative_view.interfaces.rest.resources;

public record TaskViewResource(
        Long id,
        String title,
        String description,
        boolean status,
        Long patientId
) {}