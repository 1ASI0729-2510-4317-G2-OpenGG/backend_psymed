package com.openGG.psymed.plattform.profiles.interfaces.rest.resorces;

public record MedicResource(Long id, String name, String lastName, String email, String phone, String specialty, String address, String description) {

    public MedicResource {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
    }
}
