package com.openGG.psymed.plattform.Medical_Management.tasks.interfaces.rest.resorces;

public record CreateTaskResource(String title, String description, boolean status) {

    public CreateTaskResource {
        if (title == null || title.isBlank()) throw new IllegalArgumentException("Title cannot be null or blank");
        if (description == null || description.isBlank()) throw new IllegalArgumentException("Description cannot be null or blank");
    }
}
