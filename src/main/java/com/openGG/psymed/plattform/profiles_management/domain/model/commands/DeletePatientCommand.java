package com.openGG.psymed.plattform.profiles_management.domain.model.commands;

public record DeletePatientCommand(Long patientId) {

    public DeletePatientCommand {
        if (patientId == null || patientId <= 0) {
            throw new IllegalArgumentException("Patient ID must be a valid positive number");
        }
    }
}
