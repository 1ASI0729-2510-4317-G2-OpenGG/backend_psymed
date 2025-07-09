package com.openGG.psymed.plattform.Medics.medic_sections.application.internal.commandservices;

import com.openGG.psymed.plattform.Medics.medic_sections.domain.model.commands.CreateSectionCommand;
import com.openGG.psymed.plattform.Medics.medic_sections.domain.model.entities.Section;
import com.openGG.psymed.plattform.Medics.medic_sections.infrastructure.persistence.jpa.repositories.SectionRepository;
import org.springframework.stereotype.Service;

/**
 * Service implementation responsible for handling commands related to medical sections.
 * Manages the creation and persistence of {@link Section} entities.
 */

@Service
public class SectionCommandServiceImpl {

    private final SectionRepository sectionRepository;

    /**
     * Constructs a new {@code SectionCommandServiceImpl} with the given repository.
     *
     * @param sectionRepository the repository used to persist section entities
     */

    public SectionCommandServiceImpl(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    /**
     * Handles the creation of a new section based on the provided command.
     *
     * @param command the command object containing the data to create a new section,
     *                such as patient ID, type, content, and creation date
     * @return the newly created and persisted {@link Section}
     */

    public Section handle(CreateSectionCommand command) {
        Section section = new Section();
        section.setPatientId(command.patientId());
        section.setType(command.type());
        section.setContent(command.content());
        section.setCreatedAt(command.createdAt());
        return sectionRepository.save(section);
    }
}