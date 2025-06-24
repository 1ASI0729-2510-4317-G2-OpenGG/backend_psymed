package com.openGG.psymed.plattform.profiles_management.domain.model.queries;

public record GetMedicByLastNameQuery(String lastName) {


    public GetMedicByLastNameQuery {
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name cannot be null or empty");
        }
    }
}
