package com.openGG.psymed.plattform.profiles.interfaces.rest.resorces;

import java.time.LocalDate;

public record CreatePatientResource(String name, String lastName, String dni, String email, String phone, LocalDate birthDate) {

    public CreatePatientResource {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name cannot be null or blank");
        if (lastName == null || lastName.isBlank()) throw new IllegalArgumentException("Last name cannot be null or blank");
        if (dni == null || dni.isBlank()) throw new IllegalArgumentException("DNI cannot be null or blank");
        if (email == null || email.isBlank()) throw new IllegalArgumentException("Email cannot be null or blank");
        if (phone == null || phone.isBlank()) throw new IllegalArgumentException("Phone cannot be null or blank");
        if (birthDate == null) throw new IllegalArgumentException("Birth date cannot be null");
    }
}
