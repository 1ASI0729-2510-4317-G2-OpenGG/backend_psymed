package com.openGG.psymed.plattform.medication_management.interfaces.rest.transform;

import com.openGG.psymed.plattform.medication_management.domain.model.commands.CreatePillsCommand;
import com.openGG.psymed.plattform.medication_management.interfaces.rest.resorces.CreatePillResource;

public class CreatePillCommandFromResourceAssembler {
    public static CreatePillsCommand toCommandFromResource (CreatePillResource resource)
    {
        return new CreatePillsCommand(resource.name(), resource.description(), resource.patientId(), resource.interval(), resource.quantity());
    }
}
