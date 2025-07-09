package com.openGG.psymed.plattform.profiles.interfaces.rest.resources;

public record CreateProfessionalProfileResource(
    String firstName,
    String lastName,
    String street,
    String city,
    String country,
    String email,
    String username,
    String password
) {
}
