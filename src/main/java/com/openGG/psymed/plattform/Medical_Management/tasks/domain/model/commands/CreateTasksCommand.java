package com.openGG.psymed.plattform.Medical_Management.tasks.domain.model.commands;

public record CreateTasksCommand(String title, String description, boolean status) {
    public CreateTasksCommand {
        if(title == null || title.isBlank())
            throw new IllegalArgumentException("Task title cannot be null or empty");
        if(description == null || description.isBlank())
            throw new IllegalArgumentException("Task description cannot be null or empty");
    }
}