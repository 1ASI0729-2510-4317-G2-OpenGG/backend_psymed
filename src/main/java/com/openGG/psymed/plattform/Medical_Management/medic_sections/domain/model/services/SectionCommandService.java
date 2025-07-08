package com.openGG.psymed.plattform.Medical_Management.medic_sections.domain.model.services;

import com.openGG.psymed.plattform.Medical_Management.medic_sections.domain.model.commands.CreateSectionCommand;
import com.openGG.psymed.plattform.Medical_Management.medic_sections.domain.model.entities.Section;

/**
 * Service interface for handling commands related to {@link Section} entities.
 * This interface defines operations such as creating and deleting sections with ownership validation.
 */
public interface SectionCommandService {

    /**
     * Creates a new {@link Section} based on the provided {@link CreateSectionCommand}.
     *
     * @param command the command containing section data
     * @return the created {@link Section}
     */
    Section create(CreateSectionCommand command);

    /**
     * Deletes a {@link Section} if the specified medic is the owner.
     *
     * @param sectionId the ID of the section to be deleted
     * @param medicId   the ID of the medic attempting to delete the section
     * @throws RuntimeException if the section does not exist or
     *                          the medic is not the owner
     */
    void deleteIfOwner(Long sectionId, Long medicId);
}