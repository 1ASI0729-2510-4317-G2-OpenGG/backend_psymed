package com.openGG.psymed.plattform.profiles.domain.model.commands;

public record DeleteMedicCommand(Long medicId) {

    public DeleteMedicCommand {
        if (medicId == null || medicId <= 0) {
            throw new IllegalArgumentException("Medic ID must be a valid positive number");
        }
    }
}
