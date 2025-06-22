package com.openGG.psymed.plattform.Medical_Management.tasks.interfaces.rest.resorces;

public record TaskResource(Long id, String title, String description, boolean status) {
    public TaskResource {
        if (title == null || title.isBlank()) throw new IllegalArgumentException("Title cannot be null or blank");
        if (description == null || description.isBlank()) throw new IllegalArgumentException("Description cannot be null or blank");
    }
}