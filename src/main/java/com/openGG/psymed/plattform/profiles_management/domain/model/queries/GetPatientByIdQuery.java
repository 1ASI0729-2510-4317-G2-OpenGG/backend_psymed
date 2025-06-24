package com.openGG.psymed.plattform.profiles_management.domain.model.queries;

public record GetPatientByIdQuery(Long patientId) {

    public GetPatientByIdQuery {
        if (patientId == null || patientId <= 0) {
            throw new IllegalArgumentException("ID cannot be null or less than or equal to 0");
        }
    }
}
