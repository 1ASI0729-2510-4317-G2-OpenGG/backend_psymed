package com.openGG.psymed.plattform.profiles.domain.model.queries;

public record GetMedicByNameQuery(String name) {


    public GetMedicByNameQuery {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
    }
}
