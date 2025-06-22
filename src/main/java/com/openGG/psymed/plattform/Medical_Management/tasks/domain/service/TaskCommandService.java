package com.openGG.psymed.plattform.Medical_Management.tasks.domain.service;

import com.openGG.psymed.plattform.Medical_Management.tasks.domain.model.commands.CreateTasksCommand;
import com.openGG.psymed.plattform.Medical_Management.tasks.domain.model.commands.DeleteTaskCommand;

public interface TaskCommandService {
    Long handle (CreateTasksCommand command);

    void handle (DeleteTaskCommand command);
}