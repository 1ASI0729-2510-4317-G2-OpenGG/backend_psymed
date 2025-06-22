package com.openGG.psymed.plattform.Medical_Management.medic_sections.interfaces.rest.transform;

import com.openGG.psymed.plattform.Medical_Management.medic_sections.domain.model.commands.CreateSectionCommand;
import com.openGG.psymed.plattform.Medical_Management.medic_sections.interfaces.rest.resources.CreateSectionResource;

/**
 * Assembler class responsible for transforming a {@link CreateSectionResource}
 * into a {@link CreateSectionCommand} used by the application layer.
 */

public class CreateSectionCommandFromResourceAssembler {

    /**
     * Converts a {@link CreateSectionResource} into a {@link CreateSectionCommand}.
     *
     * @param resource the resource received from the REST client
     * @return a command object with the section's creation data
     */

    public static CreateSectionCommand toCommandFromResource(CreateSectionResource resource) {
        return new CreateSectionCommand(
                resource.patientId(),
                resource.type(),
                resource.content(),
                resource.createdAt()
        );
    }
}