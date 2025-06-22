package com.openGG.psymed.plattform.Medical_Management.Medicaments.interfaces.rest.transform;

import com.openGG.psymed.plattform.Medical_Management.Medicaments.domain.model.commands.CreatePillsCommand;
import com.openGG.psymed.plattform.Medical_Management.Medicaments.interfaces.rest.resorces.CreatePillResource;

public class CreatePillCommandFromResourceAssembler {
    public static CreatePillsCommand toCommandFromResource (CreatePillResource resource)
    {
        return new CreatePillsCommand(resource.name(), resource.description(), resource.patientId(), resource.interval(), resource.quantity());
    }
}
