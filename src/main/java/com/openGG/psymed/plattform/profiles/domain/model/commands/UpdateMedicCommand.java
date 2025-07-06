
package com.openGG.psymed.plattform.profiles.domain.model.commands;
public record UpdateMedicCommand(Long medicId, String name, String lastName, String email) {

    public UpdateMedicCommand {
        // Validación de ID de paciente
        if (medicId == null || medicId <= 0) {
            throw new IllegalArgumentException("Medic ID must be a valid positive number");
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
