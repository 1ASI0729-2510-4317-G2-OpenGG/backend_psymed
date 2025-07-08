package com.openGG.psymed.plattform.Medical_Management.medic_sections.application.internal.commandservices;

import com.openGG.psymed.plattform.Medical_Management.medic_sections.domain.model.commands.CreateSectionCommand;
import com.openGG.psymed.plattform.Medical_Management.medic_sections.domain.model.entities.Section;
import com.openGG.psymed.plattform.Medical_Management.medic_sections.domain.model.services.SectionCommandService;
import com.openGG.psymed.plattform.Medical_Management.medic_sections.infrastructure.persistence.jpa.repositories.SectionRepository;
import org.springframework.stereotype.Service;

/**
 * Implementation of the {@link SectionCommandService} responsible for handling
 * command operations related to {@link Section} entities, such as creation and deletion.
 */

@Service
public class SectionCommandServiceImpl implements SectionCommandService {

    private final SectionRepository sectionRepository;

    /**
     * Constructs the service with the given repository.
     *
     * @param sectionRepository the repository for managing {@link Section} persistence
     */
    public SectionCommandServiceImpl(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    /**
     * Creates a new {@link Section} entity from the provided command data
     * and persists it to the database.
     *
     * @param command the command containing the necessary section creation data
     * @return the persisted {@link Section} entity
     */
    @Override
    public Section create(CreateSectionCommand command) {
        Section section = new Section();
        section.setPatientId(command.patientId());
        section.setType(command.type());
        section.setContent(command.content());
        section.setCreatedAt(command.createdAt());
        section.setMedicId(command.medicId());
        return sectionRepository.save(section);
    }

    /**
     * Deletes a section by its ID if the provided medic ID matches the owner.
     *
     * @param sectionId the ID of the section to delete
     * @param medicId   the ID of the medic requesting deletion
     * @throws RuntimeException if the section does not exist or
     *                          the medic is not the owner
     */
    @Override
    public void deleteIfOwner(Long sectionId, Long medicId) {
        var section = sectionRepository.findById(sectionId)
                .orElseThrow(() -> new RuntimeException("Section not found"));

        if (!section.getMedicId().equals(medicId)) {
            throw new RuntimeException("You are not the owner of this section");
        }

        sectionRepository.deleteById(sectionId);
    }
}