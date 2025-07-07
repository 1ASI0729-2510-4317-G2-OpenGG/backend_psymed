package com.openGG.psymed.plattform.profiles.domain.model.queries;

public record GetPatientByLastNameQuery(String lastName) {


    public GetPatientByLastNameQuery {
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name cannot be null or empty");
        }
    }
}
