package com.openGG.psymed.plattform.Medics.Medicaments.domain.model.queries;

public record GetPillByNameQuery(String name) {
    public GetPillByNameQuery {
        if(name == null || name.isBlank())
            throw new IllegalArgumentException("Name cannot be null or empty");
    }
}