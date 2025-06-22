package com.openGG.psymed.plattform.Medical_Management.tasks.domain.model.queries;

public record GetTaskByTitleQuery(String title) {
    public GetTaskByTitleQuery {
        if(title == null || title.isBlank())
            throw new IllegalArgumentException("Name cannot be null or empty");
    }
}