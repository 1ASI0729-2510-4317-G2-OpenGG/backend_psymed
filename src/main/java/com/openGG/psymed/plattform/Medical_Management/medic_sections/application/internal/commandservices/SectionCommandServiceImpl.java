package com.openGG.psymed.plattform.Medical_Management.medic_sections.application.internal.commandservices;

import com.openGG.psymed.plattform.Medical_Management.medic_sections.domain.model.commands.CreateSectionCommand;
import com.openGG.psymed.plattform.Medical_Management.medic_sections.domain.model.entities.Section;
import com.openGG.psymed.plattform.Medical_Management.medic_sections.infrastructure.persistence.jpa.repositories.SectionRepository;
import org.springframework.stereotype.Service;

@Service
public class SectionCommandServiceImpl {

    private final SectionRepository sectionRepository;

    public SectionCommandServiceImpl(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    public Section handle(CreateSectionCommand command) {
        Section section = new Section();
        section.setPatientId(command.patientId());
        section.setType(command.type());
        section.setContent(command.content());
        section.setCreatedAt(command.createdAt());
        return sectionRepository.save(section);
    }
}