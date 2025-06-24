package com.openGG.psymed.plattform.profiles_management.domain.model.queries;

public record GetPatientByEmailQuery(String email) {
    public GetPatientByEmailQuery {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("El email no puede ser nulo o estar vacío");
        }
    }
}
