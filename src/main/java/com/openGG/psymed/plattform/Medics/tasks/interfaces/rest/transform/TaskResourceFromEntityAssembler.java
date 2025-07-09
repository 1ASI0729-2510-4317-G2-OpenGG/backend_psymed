package com.openGG.psymed.plattform.Medics.tasks.interfaces.rest.transform;

import com.openGG.psymed.plattform.Medics.tasks.domain.model.aggregates.Tasks;
import com.openGG.psymed.plattform.Medics.tasks.interfaces.rest.resorces.TaskResource;

public class TaskResourceFromEntityAssembler {
    public static TaskResource toResourceFromEntity(Tasks entity){
        return new TaskResource(entity.getId(), entity.getTitle(), entity.getDescription(),entity.isStatus());
    }
}