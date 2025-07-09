package com.openGG.psymed.plattform.Patient.patientreport.domain.exceptions;

public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException(Long patientId) {
        super("Patient with ID %s not found".formatted(patientId));
    }
}
