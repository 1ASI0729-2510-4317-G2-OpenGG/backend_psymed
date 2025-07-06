package com.openGG.psymed.plattform.profiles.domain.model.queries;

public record GetMedicByIdQuery(Long medicId) {

    public GetMedicByIdQuery {
        if (medicId == null || medicId <= 0) {
            throw new IllegalArgumentException("ID cannot be null or less than or equal to 0");
        }
    }
}
