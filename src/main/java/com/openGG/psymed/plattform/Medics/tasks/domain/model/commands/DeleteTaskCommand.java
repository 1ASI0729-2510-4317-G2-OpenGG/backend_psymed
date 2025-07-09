package com.openGG.psymed.plattform.Medics.tasks.domain.model.commands;

public record DeleteTaskCommand(Long taskId) {
    public DeleteTaskCommand {
        if (taskId == null || taskId <= 0) {
            throw new IllegalArgumentException("Task ID must be a positive number");
        }
    }
}