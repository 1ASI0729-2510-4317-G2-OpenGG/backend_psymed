package com.openGG.psymed.plattform.Medics.Medicaments.interfaces.rest.transform;

import com.openGG.psymed.plattform.Medics.Medicaments.domain.model.commands.CreatePillsCommand;
import com.openGG.psymed.plattform.Medics.Medicaments.interfaces.rest.resorces.CreatePillResource;

public class CreatePillCommandFromResourceAssembler {
    public static CreatePillsCommand toCommandFromResource (CreatePillResource resource)
    {
        return new CreatePillsCommand(resource.name(), resource.description(), resource.patientId(), resource.interval(), resource.quantity());
    }
}
