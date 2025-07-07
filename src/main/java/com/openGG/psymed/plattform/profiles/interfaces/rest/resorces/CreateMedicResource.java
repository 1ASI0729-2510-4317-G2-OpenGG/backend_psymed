package com.openGG.psymed.plattform.profiles.interfaces.rest.resorces;
public record CreateMedicResource(String name, String lastName, String email, String phone, String specialty, String address) {

    public CreateMedicResource {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name cannot be null or blank");
        if (lastName == null || lastName.isBlank()) throw new IllegalArgumentException("Last name cannot be null or blank");
        if (email == null || email.isBlank()) throw new IllegalArgumentException("Email cannot be null or blank");
        if (phone == null || phone.isBlank()) throw new IllegalArgumentException("Phone cannot be null or blank");
        if (specialty == null || specialty.isBlank()) throw new IllegalArgumentException("Specialty cannot be null or blank");
        if (address == null || address.isBlank()) throw new IllegalArgumentException("Address cannot be null or blank");
    }
}
