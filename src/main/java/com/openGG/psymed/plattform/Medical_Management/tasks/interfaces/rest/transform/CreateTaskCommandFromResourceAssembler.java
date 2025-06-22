package com.openGG.psymed.plattform.Medical_Management.tasks.interfaces.rest.transform;

import com.openGG.psymed.plattform.Medical_Management.tasks.domain.model.commands.CreateTasksCommand;
import com.openGG.psymed.plattform.Medical_Management.tasks.interfaces.rest.resorces.CreateTaskResource;

public class CreateTaskCommandFromResourceAssembler {
    public static CreateTasksCommand toCommandFromResource (CreateTaskResource resource)
    {
        return new CreateTasksCommand(resource.title(), resource.description(), resource.status());
    }
}
