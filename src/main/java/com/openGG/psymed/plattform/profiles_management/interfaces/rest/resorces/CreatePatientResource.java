package com.openGG.psymed.plattform.profiles_management.interfaces.rest.resorces;
public record CreatePatientResource(String name, String lastName, String email) {

    public CreatePatientResource {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name cannot be null or blank");
        if (lastName == null || lastName.isBlank()) throw new IllegalArgumentException("Last name cannot be null or blank");
        if (email == null || email.isBlank()) throw new IllegalArgumentException("Email cannot be null or blank");

    }
}
