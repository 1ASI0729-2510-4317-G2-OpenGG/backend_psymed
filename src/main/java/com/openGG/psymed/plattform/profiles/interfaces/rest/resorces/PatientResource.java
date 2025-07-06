package com.openGG.psymed.plattform.profiles.interfaces.rest.resorces;

public record PatientResource(Long id, String name, String lastName, String email) {

    public PatientResource {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
    }
}
