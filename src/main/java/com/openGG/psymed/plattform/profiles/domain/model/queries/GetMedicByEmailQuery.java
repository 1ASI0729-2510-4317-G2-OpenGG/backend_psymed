package com.openGG.psymed.plattform.profiles.domain.model.queries;

public record GetMedicByEmailQuery(String email) {
    public GetMedicByEmailQuery {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("El email no puede ser nulo o estar vacío");
        }
    }
}
