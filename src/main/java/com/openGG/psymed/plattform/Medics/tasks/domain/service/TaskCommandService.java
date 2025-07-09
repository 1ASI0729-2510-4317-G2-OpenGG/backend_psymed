package com.openGG.psymed.plattform.Medics.tasks.domain.service;

import com.openGG.psymed.plattform.Medics.tasks.domain.model.commands.CreateTasksCommand;
import com.openGG.psymed.plattform.Medics.tasks.domain.model.commands.DeleteTaskCommand;

public interface TaskCommandService {
    Long handle (CreateTasksCommand command);

    void handle (DeleteTaskCommand command);
}