package com.openGG.psymed.plattform.profiles_management.domain.model.commands;

public record CreatePatientCommand(String name, String lastName, String email) {

    public CreatePatientCommand {
        if(name == null || name.isBlank())
            throw new IllegalArgumentException("Patient name cannot be null or empty");
        if(lastName == null || lastName.isBlank())
            throw new IllegalArgumentException("Patient last name cannot be null or empty");
        if(!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"))
            throw new IllegalArgumentException("Invalid email format");
        if(name.length() > 50)
            throw new IllegalArgumentException("Patient name cannot exceed 50 characters");
        if(lastName.length() > 50)
            throw new IllegalArgumentException("Patient last name cannot exceed 50 characters");
        if(email.length() > 100)
            throw new IllegalArgumentException("Patient email cannot exceed 100 characters");

    }
}