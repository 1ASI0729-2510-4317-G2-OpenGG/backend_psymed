package com.openGG.psymed.plattform.Medical_Management.medic_sections.interfaces.rest.transform;

import com.openGG.psymed.plattform.Medical_Management.medic_sections.domain.model.entities.Section;
import com.openGG.psymed.plattform.Medical_Management.medic_sections.interfaces.rest.resources.SectionResource;
import org.springframework.stereotype.Component;

/**
 * Assembler responsible for converting a {@link Section} domain entity
 * into a {@link SectionResource} to be used in the REST API layer.
 */

@Component
public class SectionResourceFromEntityAssembler {

    /**
     * Transforms a {@code Section} entity into a {@code SectionResource}.
     *
     * @param section the domain entity representing a medical section
     * @return the resource representation used in the REST layer
     */

    public SectionResource toResource(Section section) {
        return new SectionResource(
                section.getId(),
                section.getPatientId(),
                section.getType(),
                section.getContent(),
                section.getCreatedAt(),
                section.getMedicId()
        );
    }
}