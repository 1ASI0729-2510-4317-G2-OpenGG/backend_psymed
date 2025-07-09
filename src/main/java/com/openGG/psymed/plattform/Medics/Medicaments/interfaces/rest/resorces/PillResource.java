package com.openGG.psymed.plattform.Medics.Medicaments.interfaces.rest.resorces;

public record PillResource(Long id, String name, String description, Long patientId, String interval, String quantity) {
    public PillResource {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name cannot be null or blank");
        if (description == null || description.isBlank()) throw new IllegalArgumentException("Description cannot be null or blank");
    }
}
