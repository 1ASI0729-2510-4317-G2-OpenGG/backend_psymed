
package com.openGG.psymed.plattform.profiles.domain.model.commands;
public record UpdateMedicCommand(Long medicId, String name, String lastName, String email, String phone, String specialty, String address) {

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

        // Validación de phone
        if (phone == null || phone.isBlank()) {
            throw new IllegalArgumentException("Phone cannot be null or blank");
        }

        // Validación de specialty
        if (specialty == null || specialty.isBlank()) {
            throw new IllegalArgumentException("Specialty cannot be null or blank");
        }

        // Validación de address
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address cannot be null or blank");
        }
    }
}
