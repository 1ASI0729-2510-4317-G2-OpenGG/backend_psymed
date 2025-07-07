
package com.openGG.psymed.plattform.profiles.domain.model.commands;

import java.time.LocalDate;

public record UpdatePatientCommand(Long patientId, String name, String lastName, String dni, String email, String phone, LocalDate birthDate) {

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

        // Validación de dni
        if (dni == null || dni.isBlank()) {
            throw new IllegalArgumentException("DNI cannot be null or blank");
        }

        // Validación de email
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or blank");
        }

        // Validacion de phone
        if (phone == null || phone.isBlank()) {
            throw new IllegalArgumentException("Phone cannot be null or blank");
        }

        // Validacion de birthday
        if (birthDate == null) {
            throw new IllegalArgumentException("Birth date cannot be null");
        }
    }
}
