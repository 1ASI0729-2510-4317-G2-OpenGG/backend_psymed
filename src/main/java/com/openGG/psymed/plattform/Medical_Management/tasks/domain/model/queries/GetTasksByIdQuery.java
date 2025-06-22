package com.openGG.psymed.plattform.Medical_Management.tasks.domain.model.queries;

public record GetTasksByIdQuery(Long taskId) {
    public GetTasksByIdQuery {
        if (taskId == null || taskId <= 0) throw new IllegalArgumentException("Task id cannot be 0 or less");
    }
}
