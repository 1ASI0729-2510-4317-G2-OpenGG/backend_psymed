package com.openGG.psymed.plattform.profiles.domain.model.commands;

public record CreateMedicCommand(String name, String lastName, String email) {

    public CreateMedicCommand {
        if(name == null || name.isBlank())
            throw new IllegalArgumentException("Medic name cannot be null or empty");
        if(lastName == null || lastName.isBlank())
            throw new IllegalArgumentException("Medic last name cannot be null or empty");
        if(!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"))
            throw new IllegalArgumentException("Invalid email format");
        if(name.length() > 50)
            throw new IllegalArgumentException("Medic name cannot exceed 50 characters");
        if(lastName.length() > 50)
            throw new IllegalArgumentException("Medic last name cannot exceed 50 characters");
        if(email.length() > 100)
            throw new IllegalArgumentException("Medic email cannot exceed 100 characters");

    }
}