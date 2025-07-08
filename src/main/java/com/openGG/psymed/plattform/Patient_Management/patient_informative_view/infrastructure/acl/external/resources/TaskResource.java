package com.openGG.psymed.plattform.Patient_Management.patient_informative_view.infrastructure.acl.external.resources;

public record TaskResource(
        Long id,
        String title,
        String description,
        boolean status,
        Long patientId
) {}