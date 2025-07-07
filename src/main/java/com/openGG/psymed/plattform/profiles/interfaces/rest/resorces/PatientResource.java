package com.openGG.psymed.plattform.profiles.interfaces.rest.resorces;

import java.time.LocalDate;

public record PatientResource(Long id, String name, String lastName, String dni, String email, String phone, LocalDate birthDate) {

    public PatientResource {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
    }
}
