package com.openGG.psymed.plattform.Medics.tasks.domain.model.queries;

public record GetTasksBySeccion(Long seccionId) {
    public GetTasksBySeccion {
        if (seccionId() == null || seccionId() <= 0) throw new IllegalArgumentException("Section id cannot be 0 or less");
    }
}