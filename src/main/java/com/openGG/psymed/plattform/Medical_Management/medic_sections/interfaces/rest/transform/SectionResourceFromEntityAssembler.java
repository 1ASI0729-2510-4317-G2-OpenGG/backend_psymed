package com.openGG.psymed.plattform.Medical_Management.medic_sections.interfaces.rest.transform;

import com.openGG.psymed.plattform.Medical_Management.medic_sections.domain.model.entities.Section;
import com.openGG.psymed.plattform.Medical_Management.medic_sections.interfaces.rest.resources.SectionResource;

/**
 * Assembler class responsible for transforming a {@link Section} domain entity
 * into a {@link SectionResource} used in REST responses.
 */

public class SectionResourceFromEntityAssembler {

    /**
     * Converts a {@link Section} entity into a {@link SectionResource}.
     *
     * @param section the domain entity representing a medical section
     * @return a resource object formatted for REST responses
     */

    public static SectionResource toResourceFromEntity(Section section) {
        return new SectionResource(
                section.getId(),
                section.getPatientId(),
                section.getType(),
                section.getContent(),
                section.getCreatedAt()
        );
    }
}