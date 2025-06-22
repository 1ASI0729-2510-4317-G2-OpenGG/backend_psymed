package com.openGG.psymed.plattform.Medical_Management.medic_sections.interfaces.rest.transform;

import com.openGG.psymed.plattform.Medical_Management.medic_sections.domain.model.entities.Section;
import com.openGG.psymed.plattform.Medical_Management.medic_sections.interfaces.rest.resources.SectionResource;

public class SectionResourceFromEntityAssembler {
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