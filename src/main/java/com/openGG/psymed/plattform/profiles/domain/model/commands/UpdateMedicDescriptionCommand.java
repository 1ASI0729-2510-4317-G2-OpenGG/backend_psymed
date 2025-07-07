package com.openGG.psymed.plattform.profiles.domain.model.commands;

public record UpdateMedicDescriptionCommand(Long medicId, String description) {

    public UpdateMedicDescriptionCommand {
        if (medicId == null || medicId <= 0) {
            throw new IllegalArgumentException("Medic ID must be valid");
        }
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be null or blank");
        }
        if (description.length() > 500) {
            throw new IllegalArgumentException("Description is too long");
        }
    }
}
