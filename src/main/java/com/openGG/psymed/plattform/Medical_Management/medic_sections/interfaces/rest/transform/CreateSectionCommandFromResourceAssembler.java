package com.openGG.psymed.plattform.Medical_Management.medic_sections.interfaces.rest.transform;

import com.openGG.psymed.plattform.Medical_Management.medic_sections.domain.model.commands.CreateSectionCommand;
import com.openGG.psymed.plattform.Medical_Management.medic_sections.interfaces.rest.resources.CreateSectionResource;
import org.springframework.stereotype.Component;

/**
 * Assembler class responsible for transforming a {@link CreateSectionResource}
 * into a {@link CreateSectionCommand} object.
 */

@Component
public class CreateSectionCommandFromResourceAssembler {


    /**
     * Converts a {@code CreateSectionResource} and the medic's ID into a {@code CreateSectionCommand}.
     *
     * @param resource the resource received from the REST API
     * @param medicId  the ID of the medic making the request
     * @return a {@code CreateSectionCommand} with the relevant data
     */

    public CreateSectionCommand toCommand(CreateSectionResource resource, Long medicId) {
        return new CreateSectionCommand(
                resource.patientId(),
                resource.type(),
                resource.content(),
                resource.createdAt(),
                medicId
        );
    }
}