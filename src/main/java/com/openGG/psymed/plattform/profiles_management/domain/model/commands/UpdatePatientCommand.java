
package com.openGG.psymed.plattform.profiles_management.domain.model.commands;
public record UpdatePatientCommand(Long patientId, String name, String lastName, String email) {

    public UpdatePatientCommand {
        // Validación de ID de paciente
        if (patientId == null || patientId <= 0) {
            throw new IllegalArgumentException("Patient ID must be a valid positive number");
        }

        // Validación de nombre
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }

        // Validación de apellido
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name cannot be null or blank");
        }

        // Validación de email
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or blank");
        }
    }
}
