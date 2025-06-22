package com.openGG.psymed.plattform.Medical_Management.medic_sections.interfaces.rest.transform;

import com.openGG.psymed.plattform.Medical_Management.medic_sections.domain.model.commands.CreateSectionCommand;
import com.openGG.psymed.plattform.Medical_Management.medic_sections.interfaces.rest.resources.CreateSectionResource;

public class CreateSectionCommandFromResourceAssembler {
    public static CreateSectionCommand toCommandFromResource(CreateSectionResource resource) {
        return new CreateSectionCommand(
                resource.patientId(),
                resource.type(),
                resource.content(),
                resource.createdAt()
        );
    }
}