package com.openGG.psymed.plattform.profiles.domain.model.queries;

public record GetPatientByNameQuery(String name) {


    public GetPatientByNameQuery {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
    }
}
